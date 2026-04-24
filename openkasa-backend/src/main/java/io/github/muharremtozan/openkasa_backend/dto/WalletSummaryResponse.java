package io.github.muharremtozan.openkasa_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WalletSummaryResponse {
    private BigDecimal balance;
    private String currency;
    private List<TransactionResponse> lastTransactions;
}
