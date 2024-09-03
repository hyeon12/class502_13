export default function MemberLayout({children}) {
    return (
        <>
        <h1>회원전용 상단부분</h1>
        {children}
        <h1>회원전용 하단부분</h1>
        </>
    );
}