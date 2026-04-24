package io.github.muharremtozan.openkasa_backend.controller;

import io.github.muharremtozan.openkasa_backend.dto.TransactionResponse;
import io.github.muharremtozan.openkasa_backend.dto.WalletResponse;
import io.github.muharremtozan.openkasa_backend.dto.WalletSummaryResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/wallet")
@CrossOrigin(origins = "http://localhost:4200")
public class WalletController {

    @GetMapping
    public WalletResponse getWallet() {
        return WalletResponse.mock();
    }

    @GetMapping("/list")
    public List<WalletResponse> getWallets() {
        return WalletResponse.mockList();
    }

    @GetMapping("/summary")
    public WalletSummaryResponse getWalletSummary() {
        List<TransactionResponse> mockTransactions = List.of(
                TransactionResponse.builder()
                        .id(UUID.randomUUID())
                        .amount(new BigDecimal("150.00"))
                        .type("DEPOSIT")
                        .description("Market Alışverişi İadesi")
                        .date(LocalDateTime.now().minusHours(2))
                        .build(),
                TransactionResponse.builder()
                        .id(UUID.randomUUID())
                        .amount(new BigDecimal("2000.00"))
                        .type("WITHDRAWAL")
                        .description("Kira Ödemesi")
                        .date(LocalDateTime.now().minusDays(1))
                        .build(),
                TransactionResponse.builder()
                        .id(UUID.randomUUID())
                        .amount(new BigDecimal("500.00"))
                        .type("DEPOSIT")
                        .description("Arkadaştan Gelen Transfer")
                        .date(LocalDateTime.now().minusDays(3))
                        .build()
        );

        return WalletSummaryResponse.builder()
                .balance(new BigDecimal("5000.00"))
                .currency("TRY")
                .lastTransactions(mockTransactions)
                .build();
    }
}
