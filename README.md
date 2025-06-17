### Part 3 Implementation Summary

This part of the project focuses on storing, processing, and displaying message data using arrays and JSON file handling in Java. Below is a summary of the features implemented:

---

### 1. Arrays Created and Populated

The following arrays were used:

* `sentMessages`: Contains all sent messages.
* `disregardedMessages`: Messages flagged as disregarded.
* `storedMessages`: Loaded from `messages.json`.
* `messageHashes`: Unique identifiers for each message.
* `messageIDs`: Numeric IDs assigned to messages.
* `recipients`: List of recipients for each message.

All arrays are correctly initialized and populated using the `populateSampleData()` method.

---

### 2. Functional Requirements Implemented

| Feature                       | Description                            | Method                     | Status |
| ----------------------------- | -------------------------------------- | -------------------------- | ------ |
| a. Display sender & recipient | Lists all sent messages with recipient | `displayAllSentMessages()` | Done   |
| b. Longest message            | Displays the longest message           | `displayLongestMessage()`  | Done   |
| c. Search by ID               | Finds message using message ID         | `searchByMessageID()`      | Done   |
| d. Search by recipient        | Lists all messages sent to a recipient | `searchByRecipient()`      | Done   |
| e. Delete by hash             | Deletes a message using its hash       | `deleteMessageByHash()`    | Done   |
| f. Display report             | Full report of all sent messages       | `displayReport()`          | Done   |

---

### 3. JSON Handling

* `storeMessageToJSON()` saves messages into `messages.json`.
* `loadStoredMessagesFromJSON()` reads and populates stored messages into `storedMessages` array.

---

### 4. Manual Feature Testing

Since unit tests could not be completed successfully in NetBeans, all features were tested manually by running the `main()` method:

* All output displayed correctly.
* `messages.json` file created successfully.
* Data retrieved and manipulated as expected.

---

### 5. Reflections

This task helped reinforce key Java programming concepts including:

* Use of lists and array structures
* Working with JSON files
* Implementing search and delete operations
* Managing output reports

While JUnit testing posed technical challenges, the core logic and output were successfully verified manually.

---

### 6. References

1. QuickBlox. 2023. *Beginner’s Guide to Chat App Architecture*. [https://quickblox.com/blog/beginners-guide-to-chat-app-architecture](https://quickblox.com/blog/beginners-guide-to-chat-app-architecture)
2. StackOverflow. Various posts on Java file handling and array manipulation.
3. Assistance received via ChatGPT, OpenAI platform, June 2025.
