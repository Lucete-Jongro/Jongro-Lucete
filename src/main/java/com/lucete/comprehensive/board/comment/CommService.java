package com.lucete.comprehensive.board.comment;

import com.lucete.comprehensive.board.inquiry.dto.InquiryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class CommService {

    private final CommMapper commMapper;
    public CommService(CommMapper commMapper) {
        this.commMapper = commMapper;
    }



    }

