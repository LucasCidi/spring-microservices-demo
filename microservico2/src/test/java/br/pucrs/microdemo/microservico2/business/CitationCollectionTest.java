package br.pucrs.microdemo.microservico2.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitationCollectionTest {

    private final CitationCollection citationCollection = new CitationCollection();

    private static final List<String> KNOWN_CITATIONS = List.of(
        "Don't hold onto things. that require a tight grip.",
        "I didn't come this far. to only come this far.",
        "Vulnerability sounds like faith and looks like courage.",
        "Each time you break your own boundaries to ensure that someone else likes you, you like yourself a little less.",
        "There is nothing stronger than a broken person who has rebuilt him/herself.",
        "Revenge is never complete; it kills the soul and poisons it."
    );

    @Test
    void getCitation_returnsNonEmpty() {
        String citation = citationCollection.getCitation();
        assertNotNull(citation);
        assertFalse(citation.isBlank());
    }

    @Test
    void getCitation_returnsOneOfKnownCitations() {
        String citation = citationCollection.getCitation();
        assertTrue(KNOWN_CITATIONS.contains(citation));
    }
}
