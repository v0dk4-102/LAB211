# LAB211
<h2>I had passed TuanVM :></h2>
<h4>Một số kinh nghiệm trước khi học LAB211 TuanVM</h4>
<h5>Trước khi bắt tay việc code phải tạo khung chương trình (hàm main) trước rồi mới từ hàm main mới code những phần khác. Phần này thể hiện toàn bộ logic của chương trình và sẽ luôn bị thầy hỏi mỗi lần lên check bài.</h5>
<h5>Những cái nên code ở hàm main: khai báo biến, gọi hàm và tuyệt đối không được code ở hàm main ngoại trừ những bài toàn liên quan quản lý thì có thể code phần điều hướng.</h5>
<h5>Không được sử dụng biến toàn cục (trừ trường hợp có lý do chính đáng để sử dụng sẽ được cho qua)</h5>
<h5>Phải comment cho phần loop, regex, và condition. Trong đó phần regex nên mô tả rõ từng regex một có ý nghĩa và cách sử dụng như nào (như [a-z]: input sẽ khớp các ký tự từ a cho đến z)</h5>
<h5>Phần đặt tên biến, hàm và class rất quan trọng. Đối với tên biến nên đặt rõ để có thể mô tả rõ biến này dùng để làm gì. Đối với tên hàm phải được đặt theo kiểu [DoSomething] thể hiện hàm dùng để làm gì. Với tên Class thì phải được đặt để dại diện cho các hàm bên trong class.</h5>
<h4>Các bước khi học LAB211 TuanVM: Gồm 4 bước: Code, Test, Check, Review</h4>
<h5>Review: xem có phải đấy là code của mình ko</h5>
<h5>Bước code là bước tự làm</h5>
<h5>Sau đó test, test đúng rồi thì chuyển qua bước check</h5>
<h5>Tại bước check: giúp các bạn chưa có kinh nghiệm và chưa làm bao h, là bước tự hỏi: tự quyết định cái gì đó, tự đặt cho mình câu hỏi đấy, và đưa ra quyết định làm như nào.</h5>
<h5>Code xong thì phải test, nếu có lỗi thì sửa, sửa xong thì test lại. Thầy hỗ trợ cái gì ? , thầy sẽ không code hộ, thầy ko test hộ, thầy hướng dẫn. VD: Lỗi thuộc từ dạng từ a → z, thì sẽ ko làm giúp, mà thầy định hướng giúp mình tìm ra lỗi.</h5>
<h3>Tự test là gì ? Làm gì để test ?</h3>
<h4>Expect: Kết quả mong muốn → Từ testcase, đề bài, 1 phần do chúng ta phân tích</h4>
<h4>Result: Kết quả thực tế</h4>
<h4>Thực hiện việc test: tiến hành compare 2 cái này với nhau còn khác nhau thì là toang !!!</h4>
<h4>Trường hợp được xem là không test:</h4>
<h5>Không xem expect</h5>
<h5>Không thèm nhìn vào result</h5>
<h5>Không tiến hành so sánh expect và result thực tế
</h5>
<h4>Chú ý: Xong bước nào test luôn bước đấy.</h4>
<h3>Cái chúng ta muốn kiểm tra thêm, ảnh hưởng thế nào đến chương trình của chúng ta ?</h3>
<h4>Nếu ảnh hưởng là có thì chắc chắn phải test và ngược lại.</h4>
<h4>Ví dụ: Nhập mảng có N phần tử thì chúng ta phải check nó ≥ 0 không phải vì nó đúng. Không phải thế, mà là nếu để cho cái mảng đấy mà bằng 0 thì chắc chắn sai vì không có cái mảng nào chứa số lượng âm phần tử</h4>
<h4>Với trường hợp input nhập vào là bình thường.</h4>
<h3>Với trường hợp input nhập vào là ngày sinh thì sao ?</h3>
<h4>Ví dụ: 7-15-2002</h4>
<h4>Phải tùy thuộc vào format, nma nếu đề bài ko yêu cầu, thì phải tự tạo một format bắt người dùng nhập theo format đó</h4>
<h4>Sau khi kiểm tra format thì xem ngày tháng đấy có tồn tại hay không</h4>
<h4>Sau đó phải kiểm tra xem cái date đấy có tương lai không</h4>
<h3>Làm thế nào từ một requirement → code tương ứng. Step by step.</h3>
<h4>Code bắt đầu từ đâu:</h4>
<h4>Dựng ra khung chương trình, code đi theo khung chương trình đấy. Khung chương trình viết ra phải đáp ứng requirement.</h4>
<h4>Từ khung chương trình đấy tạo ra code</h4>
<h4>Đặt khung chương trình trong hàm chính</h4>
<h3>Hàm chính là gì ?</h3>
<h4>Phải làm và hoàn thiện đầu tiên.</h4>
<h4>Các bước dựng lên hàm chính:</h4>
<h4>Step 1: InputSizeOfArray (Tại sao lại dựng bước này? Bước này để làm gì) int size = InputSize()</h4>
<h4>Step 2: GenArray int[] arr = GenArray(size) (Ouput của step trước sẽ là input của step này. Hãy nhớ rõ điều này)</h4>
<h4>Step 3: Display DisplayArr(arr)</h4>
<h4>Sau khi code xong hàm chính thì hãy đi code từng bước một cho đến khi đến bước cuối cùng. Cách để kiểm tra tên có đúng thì phải xem cái output mình vừa làm đấy có giống với chức năng tên hàm không.</h4>
<h4>=> Hãy nhớ là tên phải đúng với chức năng không là đi bụi đó</h4>
<h4>Như đã đề cập về cách viết hàm main thì có ba phần chính sau Main(chính)</h4>
<h5>1.Call func (tự viết)</h5>
<h5>2.Khai báo biến</h5>
<h5>3.Code điều hướng (menu)</h5>
<h4>Đến đây là hết rùi. Chúc mọi người pass LAB211 nhé :></h4>
<h4>Vì để cảm ơn công sức mọi người đã đọc đến đây nên mình sẽ bonus thêm phần câu hỏi review mà thầy đã hỏi mình nhé :v</h4>
<h5>P0001
Với bài này thì thầy đã yêu cầu mình trình bày về tư tưởng của bubble sort, thuật toán sẽ hoạt động như thế nào?
Đại khái là mình đã trả lời là thuật toán sẽ dùng 2 vòng lặp lồng nhau,
với vòng lặp đầu tiên chạy từ đầu đến cuối mảng, vòng lặp thứ 2 nằm trong vòng lặp thứ nhất thì sẽ chạy từ đầu cho tới phần tử ngay trước phần tử cuối cùng chưa được sắp xếp(phần tử có index là length-i-2), trong mỗi vòng lặp con thì sẽ so sánh 2 phần tử kề nhau</h5>
<h5>P0021
Về bài này thì thầy đã hỏi mình là sự khác nhau giữa việc chọn update tất cả attribute của 1 student và update chỉ duy nhất 1 attribute của student. Đại khái câu trả lời sẽ là việc update duy nhất 1 attribute sẽ chỉ làm cho việc update các attribute riêng biệt nhau, xử lý các trường hợp riêng lẻ và thầy có suggest mình là nên làm update tất cả attribute thay vì chỉ 1</h5>
<h5>P0071
Bài này thầy hỏi mình là làm như thế nào để biết được 2 task bị giao nhau. 
Trả lời: coi khoảng thời gian của task đã được đăng kí trước là 1 khoảng, nếu thời gian planTo của task mới nhỏ hơn planFrom của task đã được đăng kí(tức là nó xảy ra trước) hoặc thời gian planFrom của task mới lớn hơn planTo của task cũ (tức là xảy ra sau) thì 2 task sẽ không giao nhau, nếu không thỏa mãn cả 2 điều kiện trên thì chắc chắn sẽ giao nhau</h5>
<h5>P0074
Câu hỏi bài này thầy dành cho mình là làm như thế nào để nhân 2 ma trận với nhau?
Trả lời: lấy từng phần tử trong hàng của ma trận 1 nhân với phần tử tương ứng ở ma trận thứ 2 và cộng các kết quả của phép nhân vào.
Bonus: thầy hỏi index k(index ở vòng lặp thứ 3) ở đây là gì?</h5>
<h5>P0101
Với bài này, câu hỏi của thầy là em đã thực hiện việc sort như thế nào?
Với cách làm của mình thì mình sẽ trả lời là: cho class Employee implements comparable trên chính thực thể employee và sau đó override method compareTo trên thuộc tính salary, tiếp đó ở hàm sort chỉ việc gọi collectsion.sort là oke</h5>
<h5>P0102
Câu hỏi dành cho bài này là em đã thực hiện việc so sánh 2 ngày như thế nào? 
Trả lời: do em sử dụng kiểu dữ liệu date đã định nghĩa sẵn việc so sánh giữa 2 date với nhau nên em chỉ việc gọi hàm là được, có 2 hàm là after và before thì thích cái nào thì dùng cái đó</h5>
<h5>P0105
Bài này câu hỏi tương tự như bài P0101 chỉ khác phần method compareTo là so sánh dựa trên 2 thuộc tính nếu expiry date của 2 sản phẩm là giống nhau thì sẽ so sánh dựa trên manufacture date còn không thì sẽ so sánh theo expiry date</h5>
<h4>Chính thức kết thúc ở đây nhé :v Nhớ là mọi thứ mọi người phải thực sự hiểu rõ là mình đang làm gì nhé, không là toang đấy! </h4>