package com.supun.services;

import com.supun.entity.WikimediaData;
import com.supun.repository.WikimediaDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WikimediaDataService {

    private final WikimediaDataRepository wikimediaDataRepository;

    public WikimediaData saveWikimediaData(WikimediaData wikimediaData) {
       return wikimediaDataRepository.save(wikimediaData);
    }
}
