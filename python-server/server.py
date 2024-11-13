from concurrent import futures
import grpc
import wordcloud_pb2
import wordcloud_pb2_grpc
from wordcloud import WordCloud
import io
import logging

class WordCloudService(wordcloud_pb2_grpc.WordCloudServiceServicer):
    def GenerateWordCloud(self, request, context):
        text = request.text
        logging.info(f"Received text for word cloud generation: {text}")

        try:
            # Generate word cloud
            wc = WordCloud(width=800, height=400).generate(text)
            image = wc.to_image()

            # Save the image to a byte stream
            img_byte_arr = io.BytesIO()
            image.save(img_byte_arr, format='PNG')
            img_byte_arr = img_byte_arr.getvalue()

            logging.info("Word cloud generated successfully.")
            return wordcloud_pb2.WordCloudResponse(image=img_byte_arr)
        except Exception as e:
            logging.error(f"Error generating word cloud: {e}")
            context.set_details(f"Error: {e}")
            context.set_code(grpc.StatusCode.INTERNAL)
            return wordcloud_pb2.WordCloudResponse()

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    wordcloud_pb2_grpc.add_WordCloudServiceServicer_to_server(WordCloudService(), server)
    server.add_insecure_port('[::]:50051')
    server.start()
    logging.info("Python Word Cloud gRPC Server is running on port 50051")
    server.wait_for_termination()

if __name__ == '__main__':
    logging.basicConfig(level=logging.INFO)
    serve()
