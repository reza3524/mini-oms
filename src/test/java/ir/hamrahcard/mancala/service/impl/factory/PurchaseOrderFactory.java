package ir.hamrahcard.mancala.service.impl.factory;

public class PurchaseOrderFactory extends AbstractFactory<PurchaseOrder, PurchaseOrderDto, PurchaseOrderDto.Transfer> {

    ClientFactory client = new ClientFactory();
    StockFactory stock = new StockFactory();

    @Override
    public PurchaseOrder getEntity() {
        return new PurchaseOrder()
                .setCount(randomInt())
                .setPrice(randomBigDecimal())
                .setType(PurchaseType.SELL)
                .setClient(client.getEntity())
                .setStock(stock.getEntity());
    }

    @Override
    public PurchaseOrderDto getDto() {
        return new PurchaseOrderDto()
                .setCount(randomInt())
                .setPrice(randomBigDecimal())
                .setType(PurchaseType.SELL)
                .setClient(client.getDto())
                .setStock(stock.getDto());
    }

    @Override
    public PurchaseOrderDto.Transfer getTransferDto() {
        return new PurchaseOrderDto.Transfer()
                .setCount(randomInt())
                .setPrice(randomBigDecimal())
                .setType(PurchaseType.SELL)
                .setClientExchangeCode(client.getTransferDto().getExchangeCode())
                .setStockCode(stock.getTransferDto().getCode());
    }
}
