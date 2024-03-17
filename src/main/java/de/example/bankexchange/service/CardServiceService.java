package de.example.bankexchange.service;

import de.example.bankexchange.dto.CardServiceDto;
import de.example.bankexchange.entity.Card;
import de.example.bankexchange.enums.AccountServiceType;
import de.example.bankexchange.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceService {

    private final CardRepository cardRepository;

    public CardServiceService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<CardServiceDto> getAllCardServices() {
        List<Card> cardServices = cardRepository.findAll();
        return cardServices.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CardServiceDto getCardServiceById(Long id) {
        return cardRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    public CardServiceDto createCardService(CardServiceDto cardServiceDto) {
        Card cardService = convertToEntity(cardServiceDto);
        cardService = cardRepository.save(cardService);
        return convertToDto(cardService);
    }

    public void deleteCardServiceById(Long id) {
        cardRepository.deleteById(id);
    }

    private CardServiceDto convertToDto(Card cardService) {
        CardServiceDto cardServiceDto = new CardServiceDto();
        cardServiceDto.setId(cardService.getId());
        cardServiceDto.setName(String.valueOf(cardService.getName()));
        cardServiceDto.setServiceType(cardService.getServiceType());
        cardServiceDto.setCreatedAt(cardService.getCreatedAt());
        return cardServiceDto;
    }

    private Card convertToEntity(CardServiceDto cardServiceDto) {
        Card cardService = new Card();
        cardService.setName(AccountServiceType.valueOf(cardServiceDto.getName()));
        cardService.setServiceType(cardServiceDto.getServiceType());
        // Assuming createdAt is set automatically upon creation
        return cardService;
    }

    public List<CardServiceDto> getAllBankServices() {
        return null;
    }

    public CardServiceDto getBankServiceById(Long id) {
        return null;
    }

    public CardServiceDto createBankService(CardServiceDto bankServiceDto) {
        return bankServiceDto;
    }

    public void deleteBankServiceById(Long id) {
    }
}