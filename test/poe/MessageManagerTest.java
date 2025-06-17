package poe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageManagerTest {

    @BeforeEach
    public void setup() {
        // Clear all static arrays before each test
        MessageManager.sentMessages.clear();
        MessageManager.recipients.clear();
        MessageManager.messageHashes.clear();
        MessageManager.messageIDs.clear();
        MessageManager.disregardedMessages.clear();
        MessageManager.storedMessages.clear();

        // Load sample messages
        MessageManager.populateSampleData();
    }

    @Test
    public void testSentMessagesArePopulatedCorrectly() {
        assertEquals(3, MessageManager.sentMessages.size());
        assertTrue(MessageManager.sentMessages.contains("Did you get the cake?"));
        assertTrue(MessageManager.sentMessages.contains("It is dinner time!"));
        assertTrue(MessageManager.sentMessages.contains("Where are you? You are late! I have asked you to be on time."));
    }

    @Test
    public void testDisplayLongestMessage() {
        String expected = "Where are you? You are late! I have asked you to be on time.";
        assertTrue(MessageManager.sentMessages.contains(expected));
    }

    @Test
    public void testSearchByMessageID() {
        int index = MessageManager.messageIDs.indexOf("3");
        assertEquals("+27838884567", MessageManager.recipients.get(index));
        assertEquals("Where are you? You are late! I have asked you to be on time.", MessageManager.sentMessages.get(index));
    }

    @Test
    public void testDeleteMessageByHash() {
        MessageManager.deleteMessageByHash("hash3");
        assertFalse(MessageManager.messageHashes.contains("hash3"));
        assertFalse(MessageManager.sentMessages.contains("Where are you? You are late! I have asked you to be on time."));
    }

    @Test
    public void testSaveMessagesToJSON() {
        try {
            MessageManager.saveMessagesToJSON("test_output.json");
        } catch (Exception e) {
            fail("Exception occurred while saving to JSON: " + e.getMessage());
        }
    }
}