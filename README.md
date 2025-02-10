# RoomReservationJava
This is a Room Reservation Booking System coded by Java completely 
 This Java class defines the Objects_Rooms object, representing a hotel room with attributes like a serial number, type (Single, Double, Suite), cost, and whether it includes a balcony or lounge. It also contains an email field to track booking status. The class provides getter methods to retrieve room details and a setter method (askForEmail) to update the email when a room is booked. It serves as a data model for the reservation system, allowing room details to be accessed and modified dynamically


 This Java program implements a hotel room reservation system that allows users to book, cancel, and view room reservations through a console-based menu. It reads room data from a file (rooms-1 (2).txt), stores it in an ArrayList, and processes user inputs to manage reservations. The system supports different room types, pricing, and amenities such as balconies and lounges. When a room is booked, the user’s email replaces "free" in the data, and cancellations revert it. Data persistence is ensured by saving updates back to the file, maintaining an accurate record of reservations


 This text file stores structured room reservation data, where each line represents a room with details such as serial number, type (Single, Double, Suite), cost, availability of a balcony and lounge, and booking status (either "free" or an email if booked). The reservation system reads from and writes to this file to ensure data is updated and reservations are accurately recorded.
