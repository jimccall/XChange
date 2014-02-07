/**
 * Copyright (C) 2012 - 2014 Xeiam LLC http://xeiam.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.xeiam.xchange.kraken.dto.trade;

import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.Set;

import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.kraken.KrakenUtils;

public class KrakenStandardOrder {

  private final String assetPair;
  private final KrakenType type;
  private final KrakenOrderType orderType;
  private final BigDecimal price;
  private final BigDecimal secondaryPrice;
  private final BigDecimal volume;
  private final String leverage;
  private final String positionTxId;
  private final Set<KrakenOrderFlags> orderFlags;
  private final String startTime;
  private final String expireTime;
  private final String userRefId;
  private boolean validateOnly;

  public KrakenStandardOrder(String assetPair, KrakenType type, KrakenOrderType orderType, BigDecimal price, BigDecimal secondaryPrice, BigDecimal volume, String leverage, String positionTxId,
      Set<KrakenOrderFlags> orderFlags, String startTime, String expireTime, String userRefId, boolean validateOnly) {

    this.assetPair = assetPair;
    this.type = type;
    this.orderType = orderType;
    this.price = price;
    this.secondaryPrice = secondaryPrice;
    this.volume = volume;
    this.leverage = leverage;
    this.positionTxId = positionTxId;
    this.orderFlags = orderFlags;
    this.startTime = startTime;
    this.expireTime = expireTime;
    this.userRefId = userRefId;
    this.setValidateOnly(validateOnly);
  }

  public String getAssetPair() {

    return assetPair;
  }

  public KrakenType getType() {

    return type;
  }

  public KrakenOrderType getOrderType() {

    return orderType;
  }

  public BigDecimal getPrice() {

    return price;
  }

  public BigDecimal getSecondaryPrice() {

    return secondaryPrice;
  }

  public BigDecimal getVolume() {

    return volume;
  }

  public String getLeverage() {

    return leverage;
  }

  public String getPositionTxId() {

    return positionTxId;
  }

  public Set<KrakenOrderFlags> getOrderFlags() {

    return orderFlags;
  }

  public String getStartTime() {

    return startTime;
  }

  public String getExpireTime() {

    return expireTime;
  }

  public String getUserRefId() {

    return userRefId;
  }

  public boolean isValidateOnly() {

    return validateOnly;
  }

  public void setValidateOnly(boolean validateOnly) {

    this.validateOnly = validateOnly;
  }

  @Override
  public String toString() {

    return "KrakenStandardOrder [assetPair=" + assetPair + ", type=" + type + ", orderType=" + orderType + ", price=" + price + ", secondaryPrice=" + secondaryPrice + ", volume=" + volume
        + ", leverage=" + leverage + ", positionTxId=" + positionTxId + ", orderFlags=" + orderFlags + ", startTime=" + startTime + ", expireTime=" + expireTime + ", userRefId=" + userRefId
        + ", validateOnly=" + validateOnly + "]";
  }
  
  public static KrakenOrderBuilder getMarketOrderBuilder(CurrencyPair currencyPair, KrakenType type, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.MARKET, volume);
  }

  public static KrakenOrderBuilder getLimitOrderBuilder(CurrencyPair currencyPair, KrakenType type, BigDecimal limitPrice, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.LIMIT, volume).withPrice(limitPrice);
  }

  public static KrakenOrderBuilder getStopLossOrderBuilder(CurrencyPair currencyPair, KrakenType type, BigDecimal stopLossPrice, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.STOP_LOSS, volume).withPrice(stopLossPrice);
  }

  public static KrakenOrderBuilder getTakeProfitOrderBuilder(CurrencyPair currencyPair, KrakenType type, BigDecimal takeProfitPrice, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.TAKE_PROFIT, volume).withPrice(takeProfitPrice);
  }

  public static KrakenOrderBuilder getStopLossProfitOrderBuilder(CurrencyPair currencyPair, KrakenType type, BigDecimal stopLossPrice, BigDecimal takeProfitPrice, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.STOP_LOSS_PROFIT, volume).withPrice(stopLossPrice).withSecondaryPrice(takeProfitPrice);
  }

  public static KrakenOrderBuilder getStopLossProfitLimitOrderBuilder(CurrencyPair currencyPair, KrakenType type, BigDecimal stopLossPrice, BigDecimal takeProfitPrice, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.STOP_LOSS_PROFIT_LIMIT, volume).withPrice(stopLossPrice).withSecondaryPrice(takeProfitPrice);
  }

  public static KrakenOrderBuilder getStopLossLimitOrderBuilder(CurrencyPair currencyPair, KrakenType type, BigDecimal stopLossTriggerPrice, BigDecimal triggeredLimitPrice, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.STOP_LOSS_LIMIT, volume).withPrice(stopLossTriggerPrice).withSecondaryPrice(triggeredLimitPrice);
  }

  public static KrakenOrderBuilder getTakeProfitLimitOrderBuilder(CurrencyPair currencyPair, KrakenType type, BigDecimal takeProfitTriggerPrice, BigDecimal triggeredLimitPrice, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.TAKE_PROFIT_LIMIT, volume).withPrice(takeProfitTriggerPrice).withSecondaryPrice(triggeredLimitPrice);
  }

  public static KrakenOrderBuilder getTrailingStopOrderBuilder(CurrencyPair currencyPair, KrakenType type, BigDecimal trailingStopOffset, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.TRAILING_STOP, volume).withPrice(trailingStopOffset);
  }

  public static KrakenOrderBuilder getTrailingStopLimitOrderBuilder(CurrencyPair currencyPair, KrakenType type, BigDecimal trailingStopOffset, BigDecimal triggeredLimitOffset, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.TRAILING_STOP_LIMIT, volume).withPrice(trailingStopOffset).withSecondaryPrice(triggeredLimitOffset);
  }

  public static KrakenOrderBuilder getStopLossAndLimitOrderBuilder(CurrencyPair currencyPair, KrakenType type, BigDecimal stopLossPrice, BigDecimal limitPrice, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.STOP_LOSS_AND_LIMIT, volume).withPrice(stopLossPrice).withSecondaryPrice(limitPrice);
  }

  public static class KrakenOrderBuilder {

    private final String assetPair;
    private final KrakenType type;
    private final KrakenOrderType orderType;
    private BigDecimal price;
    private BigDecimal secondaryPrice;
    private final BigDecimal volume;
    private String leverage;
    private String positionTxId;
    private Set<KrakenOrderFlags> orderFlags;
    private String startTime;
    private String expireTime;
    private String userRefId;
    private boolean validateOnly;

    private KrakenOrderBuilder(CurrencyPair currencyPair, KrakenType type, KrakenOrderType orderType, BigDecimal volume) {

      this.assetPair = KrakenUtils.createKrakenCurrencyPair(currencyPair);
      this.type = type;
      this.orderType = orderType;
      this.volume = volume;
      this.orderFlags = EnumSet.noneOf(KrakenOrderFlags.class);
      this.startTime = "0";
      this.positionTxId = "0";
      this.validateOnly = false;
    }

    public KrakenOrderBuilder withPrice(BigDecimal price) {

      this.price = price;
      return this;
    }

    public KrakenOrderBuilder withSecondaryPrice(BigDecimal secondaryPrice) {

      this.secondaryPrice = secondaryPrice;
      return this;
    }

    public KrakenOrderBuilder withLeverage(String leverage) {

      this.leverage = leverage;
      return this;
    }

    public KrakenOrderBuilder withPositionTxId(String positionTxId) {

      this.positionTxId = positionTxId;
      return this;
    }

    public KrakenOrderBuilder withOrderFlags(Set<KrakenOrderFlags> orderFlags) {

      this.orderFlags.addAll(orderFlags);
      return this;
    }

    public KrakenOrderBuilder withStartTime(String startTime) {

      this.startTime = startTime;
      return this;
    }

    public KrakenOrderBuilder withExpireTime(String expireTime) {

      this.expireTime = expireTime;
      return this;
    }

    public KrakenOrderBuilder withUserRefId(String userRefId) {

      this.userRefId = userRefId;
      return this;
    }

    public KrakenOrderBuilder validateOnly() {

      this.validateOnly = true;
      return this;
    }

    public KrakenStandardOrder buildOrder() {

      return new KrakenStandardOrder(assetPair, type, orderType, price, secondaryPrice, volume, leverage, positionTxId, orderFlags, startTime, expireTime, userRefId, validateOnly);
    }

    @Override
    public String toString() {

      return "KrakenOrderBuilder [assetPair=" + assetPair + ", type=" + type + ", orderType=" + orderType + ", price=" + price + ", secondaryPrice=" + secondaryPrice + ", volume=" + volume
          + ", leverage=" + leverage + ", positionTxId=" + positionTxId + ", orderFlags=" + orderFlags + ", startTime=" + startTime + ", expireTime=" + expireTime + ", userRefId=" + userRefId
          + ", validateOnly=" + validateOnly + "]";
    }

    public String getAssetPair() {

      return assetPair;
    }

    public KrakenType getType() {

      return type;
    }

    public KrakenOrderType getOrderType() {

      return orderType;
    }

    public BigDecimal getPrice() {

      return price;
    }

    public BigDecimal getSecondaryPrice() {

      return secondaryPrice;
    }

    public BigDecimal getVolume() {

      return volume;
    }

    public String getLeverage() {

      return leverage;
    }

    public String getPositionTxId() {

      return positionTxId;
    }

    public Set<KrakenOrderFlags> getOrderFlags() {

      return orderFlags;
    }

    public String getStartTime() {

      return startTime;
    }

    public String getExpireTime() {

      return expireTime;
    }

    public String getUserRefId() {

      return userRefId;
    }

    public boolean isValidateOnly() {

      return validateOnly;
    }
  }
}