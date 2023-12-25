package com.ibuc.entityService.facade;

import com.ibuc.entityService.entity.Booking;
import com.ibuc.entityService.entity.TimeSlot;
import com.ibuc.entityService.entity.User;
import com.ibuc.entityService.model.BookingRequest;
import com.ibuc.entityService.service.BookingService;
import com.ibuc.entityService.service.TimeSlotService;
import com.ibuc.entityService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingFacadeService {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private TimeSlotService timeSlotService;
    @Autowired
    private UserService userService;

    public Booking createBooking(BookingRequest bookingRequest){
        Booking newBooking = this.bookingService.createBooking(bookingRequest);

        if(newBooking != null) {
            TimeSlot timeSlot = this.timeSlotService.getTimeSlotById(bookingRequest.getTimeSlotId());
            timeSlot.setBooking(newBooking);
            timeSlot.setBooked(true);

            this.timeSlotService.updateTimeSlot(bookingRequest.getTimeSlotId(),timeSlot);

            User user = this.userService.getUserById(bookingRequest.getUserId());
            user.getBookings().add(newBooking);

            this.userService.updateUser(bookingRequest.getUserId(),user);
        }

        return newBooking;
    }
}
