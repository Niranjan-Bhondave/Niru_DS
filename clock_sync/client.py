# Python3 program imitating a client process for clock synchronization

from timeit import default_timer as timer
from dateutil import parser
import threading
import datetime
import socket
import time

# Client thread function used to send time to server
def startSendingTime(slave_client):
    while True:
        # Send current clock time at the client to server
        slave_client.send(str(datetime.datetime.now()).encode())
        print("Recent time sent successfully\n")
        time.sleep(5)  # Wait 5 seconds before sending again

# Client thread function used to receive synchronized time from server
def startReceivingTime(slave_client):
    while True:
        # Receive synchronized time data from server
        Synchronized_time = parser.parse(slave_client.recv(1024).decode())
        print("Synchronized time at the client is: " + str(Synchronized_time) + "\n")

# Function to initiate the client (slave)
def initiateSlaveClient(port=8080):
    slave_client = socket.socket()  # Create a socket object
    slave_client.connect(('127.0.0.1', port))  # Connect to the server (localhost)

    print("Starting to send time to server\n")
    send_time_thread = threading.Thread(target=startSendingTime, args=(slave_client,))
    send_time_thread.start()

    print("Starting to receive synchronized time from server\n")
    receive_time_thread = threading.Thread(target=startReceivingTime, args=(slave_client,))
    receive_time_thread.start()

# Driver function
if __name__ == '__main__':
    # Initialize the Slave/Client
    initiateSlaveClient(port=8080)
