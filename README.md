# Java RMI Shopping Cart

This project is a simple implementation of a Java RMI (Remote Method Invocation) shopping cart system. It includes a `Server` class that sets up a registry and binds several products to it, and `Admin` and `Customer` clients that interact with the server.

## Code Overview

The `Server` class in `Server.java` creates a few `Product` objects and a `Cart` object. Each `Product` and the `Cart` are then exported as a stub using `UnicastRemoteObject.exportObject()`. These stubs are bound to a registry which is set up on localhost at port 9100.

The products created are:

- Laptop: An Acer Aspire laptop
- MobilePhone: A Chingchong Xen mobile phone
- Charger: A Lenovo Charger
- PowerBank: A Panasonic PowerBank

The `Admin` and `Customer` clients can look up the product and cart stubs in the registry using their names ("laptop", "mobilePhone", "charger", "powerBank", and "access_cart") and interact with them as if they were local objects.

## Directory Structure

The project is organized into two main directories:

- `server`: Contains the `Server.java`, `Product.java`, `ProductInterface.java`, `CartInterface.java`, and `Cart.java` files.
- `client`: Contains the `Admin.java`, `Customer.java`, `ProductInterface.java`, and `CartInterface.java` files.

## Running the Server

To run the server, navigate to the `server` directory and execute the `Server` class. This will set up the registry and bind the product and cart stubs to it. The server will print "Server has been started..." to indicate successful setup.

## Running the Clients

To run the `Admin` or `Customer` clients, navigate to the `client` directory and execute the respective class. The clients will interact with the server as if the `Product` and `Cart` objects were local to them.

## CLI Commands

To start the RMI registry, compile and run the server, compile and run the clients, use the following commands:

- Start RMI registry: `start rmiregistry 9100`
- Compile and run server: `javac Server.java` and `java Server`
- Compile and run client: `javac Admin.java` and `java Admin` or `javac Customer.java` and `java Customer`
