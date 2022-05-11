package br.com.meli.onboarding.service;

import br.com.meli.onboarding.commons.exception.CriarPreferenciaException;
import br.com.meli.onboarding.commons.exception.MPIntegrationException;
import br.com.meli.onboarding.v1.rs.request.ItemPreferenciaDTO;
import br.com.meli.onboarding.v1.rs.request.PreferenciaRequestDTO;
import br.com.meli.onboarding.v1.rs.response.PreferenciaResponseDTO;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.client.preference.PreferenceTrackRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PreferenciaService implements IPreferenciaService {

    @Override
    public PreferenciaResponseDTO criar(PreferenciaRequestDTO preferenciaRequestDTO) {
        PreferenceClient client = new PreferenceClient();
        List<PreferenceItemRequest> items = new ArrayList<>();
        try {
            for(ItemPreferenciaDTO preferenciaItem : preferenciaRequestDTO.getItems()) {
                PreferenceItemRequest item =
                        PreferenceItemRequest.builder()
                                .title(preferenciaItem.getTitle())
                                .description(preferenciaItem.getDescription())
                                .pictureUrl(preferenciaItem.getPictureUrl())
                                .quantity(preferenciaItem.getQuantity())
                                .currencyId(preferenciaItem.getCurrencyId())
                                .unitPrice(preferenciaItem.getUnitPrice())
                                .build();
                items.add(item);
            }
            List<PreferenceTrackRequest> tracks = new ArrayList<>();
            PreferenceTrackRequest googleTrack = PreferenceTrackRequest.builder().type("google_ad").build();
            tracks.add(googleTrack);
            PreferenceRequest request = PreferenceRequest.builder().items(items).tracks(tracks).build();
            return new PreferenciaResponseDTO(Long.valueOf(client.create(request).getId()));
        } catch (MPException | MPApiException exception) {
            log.error("Error integracao PreferenciaService.criar() " + exception.getMessage(), exception);
            throw new MPIntegrationException();
        } catch (Exception exception) {
            log.error("Error PreferenciaService.criar() " + exception.getMessage(), exception);
            throw new CriarPreferenciaException();
        }
    }
}
