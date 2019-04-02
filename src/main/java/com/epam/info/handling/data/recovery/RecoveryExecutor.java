package com.epam.info.handling.data.recovery;

import com.epam.info.handling.data.composite.Component;
import com.epam.info.handling.data.recovery.exception.TextRecoveryInvalidLexemeValueException;

public interface RecoveryExecutor {
    String executeRecovery(Component component) throws TextRecoveryInvalidLexemeValueException;
}
