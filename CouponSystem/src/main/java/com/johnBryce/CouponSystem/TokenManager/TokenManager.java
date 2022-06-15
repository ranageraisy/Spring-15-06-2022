package com.johnBryce.CouponSystem.TokenManager;

import com.johnBryce.CouponSystem.exceptions.CustomException;
import com.johnBryce.CouponSystem.exceptions.ErrorMsg;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TokenManager {

    private Map<UUID, Info> tokens = new HashMap<>();

    public UUID addToken(Info info) {

        deleteEntriesByUserID(info.getId());
        UUID uuid = UUID.randomUUID();
        tokens.put(uuid, info);

        return uuid;

    }

    private void deleteEntriesByUserID(int id) {
        tokens.entrySet().removeIf(obj -> obj.getValue().getId() == id);
    }

    public int getId(UUID uuid) throws CustomException {

        Info info = tokens.get(uuid);
        if (info == null) {
            throw new CustomException(ErrorMsg.ID_NOT_FOUND);
        }
        return tokens.get(uuid).getId();
    }


}
