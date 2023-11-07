package ir.hamrahcard.mancala.service.impl.factory;

import ir.hamrahcard.mancala.domain.Pit;
import ir.hamrahcard.mancala.dto.PitDto;

public class ClientFactory extends AbstractFactory<Pit, PitDto, PitDto.Transfer> {
    @Override
    public Pit getEntity() {
        return new Pit()
                .setFirstname(FAKER.name().firstName())
                .setLastname(FAKER.name().lastName())
                .setExchangeCode(getUniqueString());
    }

    @Override
    public PitDto getDto() {
        return new PitDto()
                .setFirstname(FAKER.name().firstName())
                .setLastname(FAKER.name().lastName())
                .setExchangeCode(getUniqueString());
    }

    @Override
    public PitDto.Transfer getTransferDto() {
        return new PitDto.Transfer()
                .setFirstname(FAKER.name().firstName())
                .setLastname(FAKER.name().lastName())
                .setExchangeCode(getUniqueString());
    }
}
