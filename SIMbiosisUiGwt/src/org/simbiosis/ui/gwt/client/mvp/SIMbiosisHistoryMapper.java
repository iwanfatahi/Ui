package org.simbiosis.ui.gwt.client.mvp;

import org.simbiosis.ui.gwt.client.main.Main;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * PlaceHistoryMapper interface is used to attach all places which the
 * PlaceHistoryHandler should be aware of. This is done via the @WithTokenizers
 * annotation or by extending PlaceHistoryMapperWithFactory and creating a
 * separate TokenizerFactory.
 */
@WithTokenizers({ Main.Tokenizer.class })
public interface SIMbiosisHistoryMapper extends PlaceHistoryMapper {
}
