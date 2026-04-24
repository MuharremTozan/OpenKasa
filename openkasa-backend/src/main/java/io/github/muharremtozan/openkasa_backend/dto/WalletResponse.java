package io.github.muharremtozan.openkasa_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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
    private UUID ownerId;

    /**
     * Static method to generate mock data for frontend testing.
     */
    public static WalletResponse mock() {
        return WalletResponse.builder()
                .id(UUID.randomUUID())
                .name("Main Savings Wallet")
                .balance(new BigDecimal("1500.50"))
                .currency("TRY")
                .ownerId(UUID.randomUUID())
                .build();
    }
}
