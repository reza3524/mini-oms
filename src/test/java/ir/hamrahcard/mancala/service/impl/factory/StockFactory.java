package ir.hamrahcard.mancala.service.impl.factory;

public class StockFactory extends AbstractFactory<Stock, StockDto, StockDto.Transfer> {
    @Override
    public Stock getEntity() {
        return new Stock()
                .setCode(FAKER.name().title());
    }

    @Override
    public StockDto getDto() {
        return new StockDto()
                .setCode(FAKER.name().title());
    }

    @Override
    public StockDto.Transfer getTransferDto() {
        return new StockDto.Transfer()
                .setCode(FAKER.name().title());
    }
}
