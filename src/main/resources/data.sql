
-- pass = 123456
INSERT INTO users (user_id, username, password_hash, full_name, email, phone_number, role, is_active, created_at, updated_at, deleted) VALUES
(1, 'admin01', '$2a$10$.w35zZJqsnPdMIbGxVAJHuFSzEpaDCL9M3u1/dYfTxBPbDFVp0MW.', 'Nguyễn Quản Trị', 'admin@university.edu.vn', '0901234567', 'ADMIN', true, NOW(), NOW(), false),
(2, 'gv_minh', '$2a$10$.w35zZJqsnPdMIbGxVAJHuFSzEpaDCL9M3u1/dYfTxBPbDFVp0MW.', 'Lê Quang Minh', 'minh.lq@university.edu.vn', '0912345678', 'MENTOR', true, NOW(), NOW(), false),
(3, 'gv_thu', '$2a$10$.w35zZJqsnPdMIbGxVAJHuFSzEpaDCL9M3u1/dYfTxBPbDFVp0MW.', 'Phạm Thị Thu', 'thu.pt@university.edu.vn', '0912345679', 'MENTOR', true, NOW(), NOW(), false),
(4, 'gv_tung', '$2a$10$.w35zZJqsnPdMIbGxVAJHuFSzEpaDCL9M3u1/dYfTxBPbDFVp0MW.', 'Trần Thanh Tùng', 'tung.tt@university.edu.vn', '0912345680', 'MENTOR', true, NOW(), NOW(), false),
(5, 'gv_lan', '$2a$10$.w35zZJqsnPdMIbGxVAJHuFSzEpaDCL9M3u1/dYfTxBPbDFVp0MW.', 'Hoàng Hương Lan', 'lan.hh@university.edu.vn', '0912345681', 'MENTOR', true, NOW(), NOW(), false),
(6, 'sv_an', '$2a$10$.w35zZJqsnPdMIbGxVAJHuFSzEpaDCL9M3u1/dYfTxBPbDFVp0MW.', 'Nguyễn Văn An', 'an.nv@student.edu.vn', '0321234501', 'STUDENT', true, NOW(), NOW(), false),
(7, 'sv_binh', '$2a$10$.w35zZJqsnPdMIbGxVAJHuFSzEpaDCL9M3u1/dYfTxBPbDFVp0MW.', 'Trần Thị Bình', 'binh.tt@student.edu.vn', '0321234502', 'STUDENT', true, NOW(), NOW(), false),
(8, 'sv_cuong', '$2a$10$.w35zZJqsnPdMIbGxVAJHuFSzEpaDCL9M3u1/dYfTxBPbDFVp0MW.', 'Lê Văn Cường', 'cuong.lv@student.edu.vn', '0321234503', 'STUDENT', true, NOW(), NOW(), false),
(9, 'sv_dung', '$2a$10$.w35zZJqsnPdMIbGxVAJHuFSzEpaDCL9M3u1/dYfTxBPbDFVp0MW.', 'Phạm Tuấn Dũng', 'dung.pt@student.edu.vn', '0321234504', 'STUDENT', true, NOW(), NOW(), false),
(10, 'sv_hoa', '$2a$10$.w35zZJqsnPdMIbGxVAJHuFSzEpaDCL9M3u1/dYfTxBPbDFVp0MW.', 'Vũ Thị Hoa', 'hoa.vt@student.edu.vn', '0321234505', 'STUDENT', true, NOW(), NOW(), false);

INSERT INTO students (user_id, student_id, student_code, major, class, date_of_birth, address, created_at, updated_at, deleted) VALUES
(6, 1, 'SV001', 'Công nghệ thông tin', 'CNTT-K20A', '2002-05-15', 'Hà Nội', NOW(), NOW(), false),
(7, 2, 'SV002', 'Công nghệ thông tin', 'CNTT-K20A', '2002-08-20', 'Hải Phòng', NOW(), NOW(), false),
(8, 3, 'SV003', 'An toàn thông tin', 'ATTT-K20B', '2002-02-10', 'Đà Nẵng', NOW(), NOW(), false),
(9, 4, 'SV004', 'Hệ thống thông tin', 'HTTT-K20A', '2002-11-30', 'Cần Thơ', NOW(), NOW(), false),
(10, 5, 'SV005', 'Công nghệ thông tin', 'CNTT-K20C', '2002-01-25', 'Nam Định', NOW(), NOW(), false);

INSERT INTO mentors (user_id, mentor_id, department, academic_rank, created_at, updated_at, deleted) VALUES
(2, 2, 'Khoa CNTT', 'Tiến sĩ', NOW(), NOW(), false),
(3, 3, 'Khoa CNTT', 'Thạc sĩ', NOW(), NOW(), false),
(4, 4, 'Khoa An toàn thông tin', 'Phó Giáo sư', NOW(), NOW(), false),
(5, 5, 'Khoa Hệ thống thông tin', 'Thạc sĩ', NOW(), NOW(), false);


INSERT INTO internship_phases (phase_id, phase_name, start_date, end_date, description, created_at, updated_at, deleted) VALUES
(1, 'Thực tập cơ sở 2024', '2024-01-15', '2024-03-15', 'Giai đoạn làm quen doanh nghiệp', NOW(), NOW(), false),
(2, 'Thực tập tốt nghiệp 2024', '2024-04-01', '2024-07-31', 'Giai đoạn thực hiện đồ án', NOW(), NOW(), false);

INSERT INTO evaluation_criteria (criterion_id, criterion_name, description, max_score, created_at, updated_at, deleted) VALUES
(1, 'Thái độ làm việc', 'Điểm chuyên cần và tác phong', 10, NOW(), NOW(), false),
(2, 'Kỹ năng chuyên môn', 'Khả năng áp dụng kiến thức', 10, NOW(), NOW(), false),
(3, 'Kỹ năng mềm', 'Giao tiếp và làm việc nhóm', 10, NOW(), NOW(), false),
(4, 'Chất lượng báo cáo', 'Độ chi tiết và đúng hạn', 10, NOW(), NOW(), false),
(5, 'Tính sáng tạo', 'Các đóng góp mới cho dự án', 10, NOW(), NOW(), false);


INSERT INTO assessment_rounds (round_id, phase_id, round_name, start_date, end_date, description, is_active, created_at, updated_at, deleted) VALUES
(1, 1, 'Đánh giá giữa kỳ (TTCS)', '2024-02-10', '2024-02-15', 'Mentor đánh giá sau 4 tuần', true, NOW(), NOW(), false),
(2, 1, 'Đánh giá cuối kỳ (TTCS)', '2024-03-10', '2024-03-20', 'Tổng kết thực tập cơ sở', true, NOW(), NOW(), false),
(3, 2, 'Đánh giá giữa kỳ (TTTN)', '2024-05-15', '2024-05-20', 'Kiểm tra tiến độ đồ án', true, NOW(), NOW(), false);


INSERT INTO round_criteria (round_criterion_id, round_id, criterion_id, weight, created_at, updated_at, deleted) VALUES
(1, 1, 1, 0.5, NOW(), NOW(), false), -- Đợt 1, Tiêu chí thái độ, trọng số 50%
(2, 1, 2, 0.5, NOW(), NOW(), false), -- Đợt 1, Tiêu chí chuyên môn, trọng số 50%
(3, 2, 1, 0.2, NOW(), NOW(), false), -- Đợt 2, Thái độ 20%
(4, 2, 2, 0.4, NOW(), NOW(), false), -- Đợt 2, Chuyên môn 40%
(5, 2, 4, 0.4, NOW(), NOW(), false); -- Đợt 2, Báo cáo 40%

INSERT INTO internship_assignments (assignment_id, student_id, mentor_id, phase_id, assigned_date, status, created_at, updated_at, deleted) VALUES
(1, 1, 2, 1, '2024-01-10', 'IN_PROGRESS', NOW(), NOW(), false),
(2, 2, 2, 1, '2024-01-10', 'IN_PROGRESS', NOW(), NOW(), false),
(3, 3, 3, 1, '2024-01-10', 'IN_PROGRESS', NOW(), NOW(), false),
(4, 4, 4, 1, '2024-01-10', 'IN_PROGRESS', NOW(), NOW(), false),
(5, 5, 5, 1, '2024-01-10', 'IN_PROGRESS', NOW(), NOW(), false);


INSERT INTO assessment_results (result_id, assignment_id, round_id, criterion_id, score, comments, evaluated_by, evaluation_date, created_at, updated_at, deleted) VALUES
(1, 1, 1, 1, 9.5, 'Đi làm đầy đủ, đúng giờ', 2, '2024-02-12', NOW(), NOW(), false),
(2, 1, 1, 2, 8.0, 'Nắm bắt kỹ thuật nhanh', 2, '2024-02-12', NOW(), NOW(), false),
(3, 2, 1, 1, 10.0, 'Rất tích cực', 2, '2024-02-13', NOW(), NOW(), false),
(4, 3, 1, 1, 7.5, 'Cần cải thiện giờ giấc', 3, '2024-02-12', NOW(), NOW(), false),
(5, 4, 1, 2, 8.5, 'Kỹ năng code tốt', 4, '2024-02-14', NOW(), NOW(), false);


-- Reset sequences to prevent duplicate key violations on subsequent auto-generated inserts (POST requests)
SELECT setval(coalesce(pg_get_serial_sequence('users', 'user_id'), 'users_user_id_seq'), coalesce(max(user_id), 1)) FROM users;
SELECT setval(coalesce(pg_get_serial_sequence('students', 'student_id'), 'students_student_id_seq'), coalesce(max(student_id), 1)) FROM students;
SELECT setval(coalesce(pg_get_serial_sequence('mentors', 'mentor_id'), 'mentors_mentor_id_seq'), coalesce(max(mentor_id), 1)) FROM mentors;
SELECT setval(coalesce(pg_get_serial_sequence('internship_phases', 'phase_id'), 'internship_phases_phase_id_seq'), coalesce(max(phase_id), 1)) FROM internship_phases;
SELECT setval(coalesce(pg_get_serial_sequence('evaluation_criteria', 'criterion_id'), 'evaluation_criteria_criterion_id_seq'), coalesce(max(criterion_id), 1)) FROM evaluation_criteria;
SELECT setval(coalesce(pg_get_serial_sequence('assessment_rounds', 'round_id'), 'assessment_rounds_round_id_seq'), coalesce(max(round_id), 1)) FROM assessment_rounds;
SELECT setval(coalesce(pg_get_serial_sequence('round_criteria', 'round_criterion_id'), 'round_criteria_round_criterion_id_seq'), coalesce(max(round_criterion_id), 1)) FROM round_criteria;
SELECT setval(coalesce(pg_get_serial_sequence('internship_assignments', 'assignment_id'), 'internship_assignments_assignment_id_seq'), coalesce(max(assignment_id), 1)) FROM internship_assignments;
SELECT setval(coalesce(pg_get_serial_sequence('assessment_results', 'result_id'), 'assessment_results_result_id_seq'), coalesce(max(result_id), 1)) FROM assessment_results;


