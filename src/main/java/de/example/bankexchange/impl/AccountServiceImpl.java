package de.example.bankexchange.impl;

import de.example.bankexchange.entity.Account;
import de.example.bankexchange.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl {



}
/*
Управление картами:

Выпуск карт: Клиент может запросить выпуск новой банковской карты. Бизнес-логика включает в
себя проверку клиентской истории, генерацию уникального номера карты и ее активацию.

Блокировка/разблокировка карты: Возможность клиента заблокировать или разблокировать свою
банковскую карту через интернет-банк или мобильное приложение. Бизнес-логика также должна учитывать
дополнительные слои безопасности.

 */