package com.learn.time.controllers.encourage;

import com.learn.time.encourage.model.Label;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LabelService {
    public List<Label> getAllLabelsForEvent(Long eventId) {
        return Collections.singletonList(Label.builder().labelId(51L).build());
    }

    public Label getLabelByIdForEvent(Long eventId, Long labelId) {
        return Label.builder().labelId(51L).build();
    }

    public Label getAllLabels() {
        return Label.builder().labelId(51L).build();
    }
}
