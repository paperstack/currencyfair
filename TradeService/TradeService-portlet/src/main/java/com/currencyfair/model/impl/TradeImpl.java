package com.currencyfair.model.impl;

import java.util.Date;

import com.liferay.portal.kernel.json.JSON;

/**
 * The extended model implementation for the Trade service. Represents a row in the &quot;TradeService_Trade&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.currencyfair.model.Trade} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class TradeImpl extends TradeBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a trade model instance should use the {@link com.currencyfair.model.Trade} interface instead.
     */
    public TradeImpl() {
    }
    
    @JSON(include=false)
    public void setTimePlaced(Date timePlaced){
    	super.setTimePlaced(timePlaced);
    }
}
