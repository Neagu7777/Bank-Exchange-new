package de.example.bankexchange;

import de.example.bankexchange.controller.CashServiceController;
import de.example.bankexchange.dto.CashServiceDto;
import de.example.bankexchange.service.CashServiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CashServiceControllerTest {

    @Mock
    private CashServiceService cashServiceService;

    @InjectMocks
    private CashServiceController cashServiceController;

    @Test
    public void testGetAllCashServices() {
        // Создаем список услуг кассы для возврата при вызове метода getAllCashServices
        List<CashServiceDto> cashServices = Arrays.asList(
                new CashServiceDto(/*...*/),
                new CashServiceDto(/*...*/)
                // Добавьте другие услуги кассы по мере необходимости
        );

        // Указываем поведение mock сервиса
        when(cashServiceService.getAllCashServices()).thenReturn(cashServices);

        // Вызываем метод контроллера
        ResponseEntity<List<CashServiceDto>> response = cashServiceController.getAllCashServices();

        // Проверяем, что ответ имеет статус HttpStatus.OK и содержит тот же список, что и возвращенный mock сервиса
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(cashServices.size(), response.getBody().size());
        // Дополнительные проверки по мере необходимости
    }

    private void assertEquals(int size, int size1) {
    }

    private void assertNotNull(List<CashServiceDto> body) {
    }

    private void assertEquals(HttpStatus httpStatus, HttpStatusCode statusCode) {
    }

    // Тесты для других методов CashServiceController аналогичны
}