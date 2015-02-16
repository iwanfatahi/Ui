package org.simbiosis.ui.bpr.system.client;

import org.simbiosis.ui.bpr.system.client.places.CompanyProfile;
import org.simbiosis.ui.bpr.system.client.places.User;
import org.simbiosis.ui.bpr.system.client.places.UserGroup;
import org.simbiosis.ui.gwt.client.mvp.SIMbiosisHistoryMapper;

import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ CompanyProfile.Tokenizer.class, UserGroup.Tokenizer.class,
		User.Tokenizer.class })
public interface AppHistoryMapper extends SIMbiosisHistoryMapper {

}
