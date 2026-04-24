package io.github.muharremtozan.openkasa_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * WalletResponse DTO class for frontend-backend communication.
 * Used for providing wallet details and mock data support.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WalletResponse {

    private UUID id;
    private String name;
    private BigDecimal balance;
    private String currency;
    private String status; // e.g., ACTIVE, FROZEN, CLOSED
    private LocalDateTime createdAt;
    private UUID ownerId;

    /**
     * Static method to generate a single mock data for testing.
     */
    public static WalletResponse mock() {
        return WalletResponse.builder()
                .id(UUID.randomUUID())
                .name("Main Savings Wallet")
                .balance(new BigDecimal("1500.50"))
                .currency("TRY")
                .status("ACTIVE")
                .createdAt(LocalDateTime.now())
                .ownerId(UUID.randomUUID())
                .build();
    }

    /**
     * Static method to generate a list of mock data for testing.
     */
    public static List<WalletResponse> mockList() {
        return List.of(
                mock(),
                WalletResponse.builder()
                        .id(UUID.randomUUID())
                        .name("Investment Account")
                        .balance(new BigDecimal("25000.00"))
                        .currency("USD")
                        .status("ACTIVE")
                        .createdAt(LocalDateTime.now().minusDays(30))
                        .ownerId(UUID.randomUUID())
                        .build(),
                WalletResponse.builder()
                        .id(UUID.randomUUID())
                        .name("Hidden Emergency Fund")
                        .balance(new BigDecimal("500.00"))
                        .currency("EUR")
                        .status("FROZEN")
                        .createdAt(LocalDateTime.now().minusMonths(2))
                        .ownerId(UUID.randomUUID())
                        .build()
        );
    }
}
