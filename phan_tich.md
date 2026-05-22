# Phân tích

## Input/Output
- Input: Các tham số giao dịch (số tiền, tài khoản đích, OTP).
- Output: Chuỗi kết quả giao dịch ("Rút tiền thành công", "Chuyển khoản thất bại: Sai OTP", …).

## Vấn đề
Hiện tại, logic kiểm tra OTP (`if (!verifyOtp(otp))`) bị lặp lại ở đầu mỗi hàm giao dịch nhạy cảm. Điều này gây:
- Code tangling: logic bảo mật trộn lẫn với logic nghiệp vụ.
- Khó bảo trì: khi thêm hàm mới, dev phải copy-paste đoạn kiểm tra OTP.
- Dễ sai sót: có thể quên hoặc viết sai điều kiện.

## Tại sao dùng Custom Annotation tối ưu hơn Pointcut theo tên hàm?
- Pointcut theo tên hàm: phụ thuộc vào quy ước đặt tên (ví dụ: add, withdraw, transfer). Nếu dev đặt tên khác hoặc đổi tên hàm, Aspect có thể bỏ sót.
- Custom Annotation (@RequiresOTP): rõ ràng, tường minh, gắn trực tiếp vào hàm cần bảo mật. Không phụ thuộc vào tên hàm, dễ đọc, dễ kiểm soát.
- Annotation giúp Separation of Concerns: nghiệp vụ chỉ tập trung vào logic chính, còn bảo mật được xử lý tập trung ở Aspect.
