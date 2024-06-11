USE [YumFilm]
GO
/****** Object:  Table [dbo].[Actor]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Actor](
	[ActorId] [int] IDENTITY(1,1) NOT NULL,
	[ActorName] [nvarchar](100) NOT NULL,
	[Status] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ActorId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ActorOfFilm]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ActorOfFilm](
	[ActorOfFilmId] [int] IDENTITY(1,1) NOT NULL,
	[ActorId] [int] NOT NULL,
	[FilmDetailId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ActorOfFilmId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CinemaRoom]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CinemaRoom](
	[CinemaRoomId] [int] IDENTITY(1,1) NOT NULL,
	[NameRoom] [nvarchar](50) NOT NULL,
	[Status] [bit] NOT NULL,
	[SeatLocationId] [int] NULL,
	[ShowTimeId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[CinemaRoomId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Country]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Country](
	[CountryId] [nvarchar](20) NOT NULL,
	[CountryName] [nvarchar](100) NOT NULL,
	[Status] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CountryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Director]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Director](
	[DirectorId] [int] IDENTITY(1,1) NOT NULL,
	[DirectorName] [nvarchar](100) NOT NULL,
	[Status] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[DirectorId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DirectorOfFilm]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DirectorOfFilm](
	[DirectorOfFilmId] [int] IDENTITY(1,1) NOT NULL,
	[DirectorId] [int] NOT NULL,
	[FilmDetailId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[DirectorOfFilmId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Film]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Film](
	[FilmId] [int] IDENTITY(1,1) NOT NULL,
	[FilmImage] [nvarchar](255) NOT NULL,
	[FilmName] [nvarchar](255) NOT NULL,
	[FilmTime] [nvarchar](255) NOT NULL,
	[PremiereDate] [date] NOT NULL,
	[Price] [float] NOT NULL,
	[Status] [bit] NOT NULL,
	[VideoTrailer] [nvarchar](255) NOT NULL,
	[CountryId] [nvarchar](20) NOT NULL,
	[Age] [int] NULL,
	[Rate] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[FilmId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[FilmDetail]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FilmDetail](
	[FilmDetailId] [int] IDENTITY(1,1) NOT NULL,
	[Description] [nvarchar](max) NOT NULL,
	[ProductionDate] [date] NOT NULL,
	[Status] [bit] NOT NULL,
	[FilmId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[FilmDetailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[FilmGenres]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FilmGenres](
	[FilmGenresId] [int] IDENTITY(1,1) NOT NULL,
	[FilmId] [int] NULL,
	[FilmTypeId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[FilmGenresId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[FilmType]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FilmType](
	[FilmTypeId] [int] IDENTITY(1,1) NOT NULL,
	[FilmTypeName] [nvarchar](100) NOT NULL,
	[Status] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[FilmTypeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Food]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Food](
	[FoodId] [int] IDENTITY(1,1) NOT NULL,
	[Description] [nvarchar](max) NULL,
	[FoodName] [nvarchar](255) NOT NULL,
	[Price] [float] NOT NULL,
	[Quantity] [int] NOT NULL,
	[Status] [bit] NOT NULL,
	[FoodImage] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[FoodId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Invoice]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Invoice](
	[InvoiceId] [bigint] IDENTITY(1,1) NOT NULL,
	[CreateDate] [datetime] NOT NULL,
	[Note] [nvarchar](255) NULL,
	[PaymentStatus] [bit] NOT NULL,
	[Status] [bit] NOT NULL,
	[Total] [float] NOT NULL,
	[PaymentId] [int] NULL,
	[UserId] [bigint] NULL,
	[VoucherId] [bigint] NULL,
 CONSTRAINT [PK__Invoice__D796AAB55D889400] PRIMARY KEY CLUSTERED 
(
	[InvoiceId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[InvoiceDetail]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[InvoiceDetail](
	[InvoiceDetailId] [bigint] IDENTITY(1,1) NOT NULL,
	[Note] [varchar](255) NULL,
	[Price] [float] NULL,
	[InvoiceId] [bigint] NULL,
	[SeatLocationId] [int] NULL,
	[ShowTimeId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[InvoiceDetailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderFood]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderFood](
	[OrderFoodId] [bigint] IDENTITY(1,1) NOT NULL,
	[Price] [float] NOT NULL,
	[Quantity] [int] NOT NULL,
	[FoodId] [int] NULL,
	[InvoiceId] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderFoodId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Payment]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Payment](
	[PaymentId] [int] IDENTITY(1,1) NOT NULL,
	[PaymentName] [nvarchar](255) NOT NULL,
	[Status] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[PaymentId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Producer]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Producer](
	[ProducerId] [int] IDENTITY(1,1) NOT NULL,
	[ProducerName] [nvarchar](100) NOT NULL,
	[Status] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ProducerId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProducerOfFilm]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProducerOfFilm](
	[ProducerOfFilmId] [int] IDENTITY(1,1) NOT NULL,
	[FilmDetailId] [int] NOT NULL,
	[ProducerId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ProducerOfFilmId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SeatLocation]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SeatLocation](
	[SeatLocationId] [int] IDENTITY(1,1) NOT NULL,
	[SeatNumber] [nvarchar](20) NOT NULL,
	[Status] [bit] NOT NULL,
	[SeatTypeId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[SeatLocationId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SeatType]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SeatType](
	[SeatTypeId] [int] IDENTITY(1,1) NOT NULL,
	[Price] [float] NOT NULL,
	[SeatTypeName] [nvarchar](50) NOT NULL,
	[Status] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[SeatTypeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ShowTime]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ShowTime](
	[ShowTimeId] [int] IDENTITY(1,1) NOT NULL,
	[Price] [float] NOT NULL,
	[ShowTimeDate] [date] NOT NULL,
	[Status] [bit] NOT NULL,
	[FilmId] [int] NULL,
	[ShowTimeListId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ShowTimeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ShowTimeList]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ShowTimeList](
	[ShowTimeListId] [int] IDENTITY(1,1) NOT NULL,
	[ShowTimeFrame] [nvarchar](100) NOT NULL,
	[Status] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ShowTimeListId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ShowTimeSeatType]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ShowTimeSeatType](
	[ShowTimeSeatTypeId] [bigint] IDENTITY(1,1) NOT NULL,
	[Price] [float] NOT NULL,
	[SeatTypeId] [int] NULL,
	[ShowTimeId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ShowTimeSeatTypeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[UserId] [bigint] IDENTITY(1,1) NOT NULL,
	[Birthdate] [date] NULL,
	[Email] [nvarchar](255) NOT NULL,
	[FirstName] [nvarchar](50) NULL,
	[LastName] [nvarchar](50) NULL,
	[Password] [nchar](60) NOT NULL,
	[PhoneNumber] [nvarchar](50) NULL,
	[Role] [bit] NULL,
	[Sex] [bit] NULL,
	[Status] [bit] NULL,
	[Username] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK__Users__1788CC4C5450E7F4] PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Voucher]    Script Date: 06/06/2024 8:17:12 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Voucher](
	[VoucherId] [bigint] NOT NULL,
	[EndDate] [datetime] NOT NULL,
	[StartDate] [datetime] NOT NULL,
	[Status] [bit] NOT NULL,
	[VoucherName] [nvarchar](255) NOT NULL,
	[VoucherValue] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[VoucherId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Actor] ON 

INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (1, N'Lý Hải', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (2, N'Thanh Hiền', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (3, N'Thái Vũ', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (4, N'Trương Minh Công', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (5, N'Tín Nguyễn', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (6, N'Quách Ngọc Tuyên', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (7, N'Ammy Minh Khuê', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (8, N'Thanh Thức', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (9, N'Trần Kim Hải', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (10, N'Đinh Y Nhung', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (11, N'Ceri Thu Hà', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (12, N'Kim Da Mi', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (13, N'Choi Woo Sik', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (14, N'Jo Min Soo', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (15, N'Park Hee Soon', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (16, N'Go Min Si', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (17, N'Jung Da Eun', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (18, N'Kim Byeong Ok', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (19, N'Oh Mi Hee', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (20, N'Lee Ki Young', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (21, N'Kwak Jin Seok', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (22, N'Lee Jong Suk', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (23, N'Trấn Thành', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (24, N'Phương Anh Đào', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (25, N'Tuấn Trần', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (26, N'Phiravich Attachitsataporn ', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (27, N'Witthawat Rattanaboonbaramee', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (28, N'Bhuripat Vejvongsatechawat', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (29, N'Mizuta Wasabi ', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (30, N'Megumi Oohara ', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (31, N'Owen Teague ', 1)
INSERT [dbo].[Actor] ([ActorId], [ActorName], [Status]) VALUES (32, N'Kevin Durand', 1)
SET IDENTITY_INSERT [dbo].[Actor] OFF
GO
SET IDENTITY_INSERT [dbo].[ActorOfFilm] ON 

INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (1, 1, 1)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (2, 2, 1)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (3, 3, 1)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (4, 4, 1)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (5, 5, 1)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (6, 6, 1)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (7, 7, 1)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (8, 8, 1)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (9, 9, 1)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (10, 10, 1)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (11, 11, 1)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (12, 12, 2)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (13, 13, 2)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (14, 14, 2)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (15, 15, 2)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (16, 16, 2)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (17, 17, 2)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (18, 18, 2)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (19, 19, 2)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (20, 20, 2)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (21, 21, 2)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (22, 22, 2)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (23, 23, 3)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (24, 24, 3)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (25, 25, 3)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (26, 26, 4)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (27, 27, 4)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (28, 28, 4)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (32, 29, 5)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (33, 30, 5)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (34, 31, 6)
INSERT [dbo].[ActorOfFilm] ([ActorOfFilmId], [ActorId], [FilmDetailId]) VALUES (35, 32, 6)
SET IDENTITY_INSERT [dbo].[ActorOfFilm] OFF
GO
SET IDENTITY_INSERT [dbo].[CinemaRoom] ON 

INSERT [dbo].[CinemaRoom] ([CinemaRoomId], [NameRoom], [Status], [SeatLocationId], [ShowTimeId]) VALUES (2, N'A1', 1, 1, 5)
INSERT [dbo].[CinemaRoom] ([CinemaRoomId], [NameRoom], [Status], [SeatLocationId], [ShowTimeId]) VALUES (3, N'A1', 1, 1, 9)
INSERT [dbo].[CinemaRoom] ([CinemaRoomId], [NameRoom], [Status], [SeatLocationId], [ShowTimeId]) VALUES (8, N'A1', 1, 1, 2)
INSERT [dbo].[CinemaRoom] ([CinemaRoomId], [NameRoom], [Status], [SeatLocationId], [ShowTimeId]) VALUES (9, N'A1', 1, 2, 5)
INSERT [dbo].[CinemaRoom] ([CinemaRoomId], [NameRoom], [Status], [SeatLocationId], [ShowTimeId]) VALUES (10, N'A1', 1, 2, 9)
INSERT [dbo].[CinemaRoom] ([CinemaRoomId], [NameRoom], [Status], [SeatLocationId], [ShowTimeId]) VALUES (11, N'A1', 1, 2, 2)
INSERT [dbo].[CinemaRoom] ([CinemaRoomId], [NameRoom], [Status], [SeatLocationId], [ShowTimeId]) VALUES (12, N'A1', 1, 4, 2)
INSERT [dbo].[CinemaRoom] ([CinemaRoomId], [NameRoom], [Status], [SeatLocationId], [ShowTimeId]) VALUES (13, N'A1', 1, 3, 2)
SET IDENTITY_INSERT [dbo].[CinemaRoom] OFF
GO
INSERT [dbo].[Country] ([CountryId], [CountryName], [Status]) VALUES (N'CN', N'Trung Quốc', 1)
INSERT [dbo].[Country] ([CountryId], [CountryName], [Status]) VALUES (N'IT', N'Ý', 1)
INSERT [dbo].[Country] ([CountryId], [CountryName], [Status]) VALUES (N'JP', N'Nhật Bản', 1)
INSERT [dbo].[Country] ([CountryId], [CountryName], [Status]) VALUES (N'KR', N'Hàn Quốc', 1)
INSERT [dbo].[Country] ([CountryId], [CountryName], [Status]) VALUES (N'TH', N'Thái Lan', 1)
INSERT [dbo].[Country] ([CountryId], [CountryName], [Status]) VALUES (N'UK', N'Anh', 1)
INSERT [dbo].[Country] ([CountryId], [CountryName], [Status]) VALUES (N'US', N'Mỹ', 1)
INSERT [dbo].[Country] ([CountryId], [CountryName], [Status]) VALUES (N'VN', N'Việt Nam', 1)
GO
SET IDENTITY_INSERT [dbo].[Director] ON 

INSERT [dbo].[Director] ([DirectorId], [DirectorName], [Status]) VALUES (1, N'Lý Hải', 1)
INSERT [dbo].[Director] ([DirectorId], [DirectorName], [Status]) VALUES (2, N'Trấn Thành', 1)
INSERT [dbo].[Director] ([DirectorId], [DirectorName], [Status]) VALUES (3, N'Park Hoon-jung', 1)
INSERT [dbo].[Director] ([DirectorId], [DirectorName], [Status]) VALUES (4, N'Phontharis Chotkijsadarsopon', 1)
INSERT [dbo].[Director] ([DirectorId], [DirectorName], [Status]) VALUES (5, N'Kazuaki Imai', 1)
SET IDENTITY_INSERT [dbo].[Director] OFF
GO
SET IDENTITY_INSERT [dbo].[DirectorOfFilm] ON 

INSERT [dbo].[DirectorOfFilm] ([DirectorOfFilmId], [DirectorId], [FilmDetailId]) VALUES (1, 1, 1)
INSERT [dbo].[DirectorOfFilm] ([DirectorOfFilmId], [DirectorId], [FilmDetailId]) VALUES (4, 3, 2)
INSERT [dbo].[DirectorOfFilm] ([DirectorOfFilmId], [DirectorId], [FilmDetailId]) VALUES (5, 2, 3)
INSERT [dbo].[DirectorOfFilm] ([DirectorOfFilmId], [DirectorId], [FilmDetailId]) VALUES (7, 4, 4)
INSERT [dbo].[DirectorOfFilm] ([DirectorOfFilmId], [DirectorId], [FilmDetailId]) VALUES (8, 5, 5)
SET IDENTITY_INSERT [dbo].[DirectorOfFilm] OFF
GO
SET IDENTITY_INSERT [dbo].[Film] ON 

INSERT [dbo].[Film] ([FilmId], [FilmImage], [FilmName], [FilmTime], [PremiereDate], [Price], [Status], [VideoTrailer], [CountryId], [Age], [Rate]) VALUES (1, N'lat-mat-7.jpg', N'Lật Mật 7', N'2 giờ 18 phút', CAST(N'2024-06-01' AS Date), 100000, 1, N'latmat7', N'VN', 13, 8.9)
INSERT [dbo].[Film] ([FilmId], [FilmImage], [FilmName], [FilmTime], [PremiereDate], [Price], [Status], [VideoTrailer], [CountryId], [Age], [Rate]) VALUES (2, N'stnt2_social_1_.jpg', N'Sát Thủ Nhân Tạo', N'2 giờ 5 phút', CAST(N'2018-06-27' AS Date), 100000, 1, N'satthunhantao', N'KR', 16, 8.5)
INSERT [dbo].[Film] ([FilmId], [FilmImage], [FilmName], [FilmTime], [PremiereDate], [Price], [Status], [VideoTrailer], [CountryId], [Age], [Rate]) VALUES (3, N'mai.jpg', N'Mai', N'2 giờ 10 phút', CAST(N'2024-06-01' AS Date), 100000, 1, N'mai', N'VN', 18, 8.2)
INSERT [dbo].[Film] ([FilmId], [FilmImage], [FilmName], [FilmTime], [PremiereDate], [Price], [Status], [VideoTrailer], [CountryId], [Age], [Rate]) VALUES (4, N'ngoidenkiquai.jpg', N'Ngôi đền kì quái 4', N'2 giờ 25 phút', CAST(N'2024-06-01' AS Date), 100000, 1, N'ngoidenkiquai', N'TH', 18, 9)
INSERT [dbo].[Film] ([FilmId], [FilmImage], [FilmName], [FilmTime], [PremiereDate], [Price], [Status], [VideoTrailer], [CountryId], [Age], [Rate]) VALUES (7, N'doraemon-movie-43.jpg', N'Nobita Và Bản Giao Hưởng Địa Cầu', N'2 giờ 29 phút', CAST(N'2024-06-01' AS Date), 100000, 1, N'doremonvanobita', N'JP', 13, 8)
INSERT [dbo].[Film] ([FilmId], [FilmImage], [FilmName], [FilmTime], [PremiereDate], [Price], [Status], [VideoTrailer], [CountryId], [Age], [Rate]) VALUES (8, N'hanh-tinh-khi.jpg', N'Hành tinh khỉ', N'2 giờ 24 phút', CAST(N'2024-12-01' AS Date), 120000, 1, N'hanhtinhkhi', N'US', 14, 8.2)
SET IDENTITY_INSERT [dbo].[Film] OFF
GO
SET IDENTITY_INSERT [dbo].[FilmDetail] ON 

INSERT [dbo].[FilmDetail] ([FilmDetailId], [Description], [ProductionDate], [Status], [FilmId]) VALUES (1, N'Một câu chuyện lần đầu được kể bằng tất cả tình yêu, và từ tất cả những hồi ức xao xuyến nhất của đấng sinh thành', CAST(N'2024-04-26' AS Date), 1, 1)
INSERT [dbo].[FilmDetail] ([FilmDetailId], [Description], [ProductionDate], [Status], [FilmId]) VALUES (2, N'Sát Thủ Nhân Tạo là bộ phim hành động li kì kể về Koo Ja-yoon – một cô bé được nuôi dưỡng trong một tổ chức đáng sợ - nơi diễn ra các cuộc thí nghiệm y học được thực hiện trên chính cơ thể con người nhằm biến họ thành những cỗ máy giết người.
	Sau khi chạy trốn khỏi tổ chức, Ja-yoon bị mất trí nhớ và được một cặp vợ chồng già nhận nuôi. 10 năm sau,
khi đã trở thành một nữ sinh trung học, Ja-yoon đăng ký tham gia một cuộc thi âm nhạc với mong muốn giúp gia đình vượt qua khó khăn tài chính. Nhưng cô không ngờ rằng, ngay từ khi hình ảnh của mình xuất hiện trên truyền hình, cuộc sống của cô bị đảo lộn hoàn toàn bởi sự truy đuổi của những kẻ lạ mặt.', CAST(N'2024-04-26' AS Date), 1, 2)
INSERT [dbo].[FilmDetail] ([FilmDetailId], [Description], [ProductionDate], [Status], [FilmId]) VALUES (3, N'Mai là một bộ phim điện ảnh Việt Nam thuộc thể loại hài – lãng mạn – chính kịch ra mắt vào năm 2024 do Trấn Thành làm đạo diễn', CAST(N'2024-04-06' AS Date), 1, 3)
INSERT [dbo].[FilmDetail] ([FilmDetailId], [Description], [ProductionDate], [Status], [FilmId]) VALUES (4, N'Hồn ma Nak với sức mạnh khủng khiếp nhất, đáng sợ nhất mà bộ đôi mỏ hỗn Balloon & First phải đối mặt để giải cứu cho trai đẹp Min Joon.', CAST(N'2024-04-06' AS Date), 1, 4)
INSERT [dbo].[FilmDetail] ([FilmDetailId], [Description], [ProductionDate], [Status], [FilmId]) VALUES (5, N'Sẽ ra sao nếu thế giới không còn âm nhạc? Phim Điện Ảnh Doraemon: Nobita Và Bản Giao Hưởng Địa Cầu là tác phẩm điện ảnh đầu tiên về chú Mèo Ú lấy đề tài âm nhạc!', CAST(N'2024-04-26' AS Date), 1, 7)
INSERT [dbo].[FilmDetail] ([FilmDetailId], [Description], [ProductionDate], [Status], [FilmId]) VALUES (6, N'Kingdom Of The Planet Of The Apes lấy bối cảnh nhiều đời sau Caesar đại đế, hành tinh này là nơi loài khỉ thống trị, còn loài người dần lui về trong bóng tối. Khi một thủ lĩnh khỉ bạo chúa bắt đầu xây dựng đế chế của riêng mình, buộc thủ lĩnh một tộc khỉ khác phải bước vào hành trình tăm tối để tìm kiếm tự do, quyết định tương lai của loài người và khỉ. ', CAST(N'2024-04-26' AS Date), 1, 8)
SET IDENTITY_INSERT [dbo].[FilmDetail] OFF
GO
SET IDENTITY_INSERT [dbo].[FilmGenres] ON 

INSERT [dbo].[FilmGenres] ([FilmGenresId], [FilmId], [FilmTypeId]) VALUES (1, 1, 8)
INSERT [dbo].[FilmGenres] ([FilmGenresId], [FilmId], [FilmTypeId]) VALUES (3, 1, 17)
INSERT [dbo].[FilmGenres] ([FilmGenresId], [FilmId], [FilmTypeId]) VALUES (4, 3, 8)
INSERT [dbo].[FilmGenres] ([FilmGenresId], [FilmId], [FilmTypeId]) VALUES (5, 3, 2)
INSERT [dbo].[FilmGenres] ([FilmGenresId], [FilmId], [FilmTypeId]) VALUES (6, 2, 1)
INSERT [dbo].[FilmGenres] ([FilmGenresId], [FilmId], [FilmTypeId]) VALUES (7, 2, 6)
INSERT [dbo].[FilmGenres] ([FilmGenresId], [FilmId], [FilmTypeId]) VALUES (8, 4, 3)
INSERT [dbo].[FilmGenres] ([FilmGenresId], [FilmId], [FilmTypeId]) VALUES (9, 4, 4)
INSERT [dbo].[FilmGenres] ([FilmGenresId], [FilmId], [FilmTypeId]) VALUES (10, 7, 3)
INSERT [dbo].[FilmGenres] ([FilmGenresId], [FilmId], [FilmTypeId]) VALUES (11, 7, 11)
INSERT [dbo].[FilmGenres] ([FilmGenresId], [FilmId], [FilmTypeId]) VALUES (12, 8, 1)
INSERT [dbo].[FilmGenres] ([FilmGenresId], [FilmId], [FilmTypeId]) VALUES (13, 8, 6)
SET IDENTITY_INSERT [dbo].[FilmGenres] OFF
GO
SET IDENTITY_INSERT [dbo].[FilmType] ON 

INSERT [dbo].[FilmType] ([FilmTypeId], [FilmTypeName], [Status]) VALUES (1, N'Hành động', 1)
INSERT [dbo].[FilmType] ([FilmTypeId], [FilmTypeName], [Status]) VALUES (2, N'Lãng mạn', 1)
INSERT [dbo].[FilmType] ([FilmTypeId], [FilmTypeName], [Status]) VALUES (3, N'Hài hước', 1)
INSERT [dbo].[FilmType] ([FilmTypeId], [FilmTypeName], [Status]) VALUES (4, N'Kinh dị', 1)
INSERT [dbo].[FilmType] ([FilmTypeId], [FilmTypeName], [Status]) VALUES (5, N'Tâm lý tội phạm', 1)
INSERT [dbo].[FilmType] ([FilmTypeId], [FilmTypeName], [Status]) VALUES (6, N'Khoa học viễn tưởng', 1)
INSERT [dbo].[FilmType] ([FilmTypeId], [FilmTypeName], [Status]) VALUES (7, N'Thanh xuân', 1)
INSERT [dbo].[FilmType] ([FilmTypeId], [FilmTypeName], [Status]) VALUES (8, N'Gia đình', 1)
INSERT [dbo].[FilmType] ([FilmTypeId], [FilmTypeName], [Status]) VALUES (9, N'Học đường', 1)
INSERT [dbo].[FilmType] ([FilmTypeId], [FilmTypeName], [Status]) VALUES (10, N'Ca nhạc', 1)
INSERT [dbo].[FilmType] ([FilmTypeId], [FilmTypeName], [Status]) VALUES (11, N'Hoạt hình', 1)
INSERT [dbo].[FilmType] ([FilmTypeId], [FilmTypeName], [Status]) VALUES (12, N'Tiểu thuyết', 1)
INSERT [dbo].[FilmType] ([FilmTypeId], [FilmTypeName], [Status]) VALUES (13, N'Kịch', 1)
INSERT [dbo].[FilmType] ([FilmTypeId], [FilmTypeName], [Status]) VALUES (14, N'Phim tài liệu', 1)
INSERT [dbo].[FilmType] ([FilmTypeId], [FilmTypeName], [Status]) VALUES (15, N'Chiến tranh', 1)
INSERT [dbo].[FilmType] ([FilmTypeId], [FilmTypeName], [Status]) VALUES (16, N'Tình cảm', 1)
INSERT [dbo].[FilmType] ([FilmTypeId], [FilmTypeName], [Status]) VALUES (17, N'Trẻ em', 1)
SET IDENTITY_INSERT [dbo].[FilmType] OFF
GO
SET IDENTITY_INSERT [dbo].[Food] ON 

INSERT [dbo].[Food] ([FoodId], [Description], [FoodName], [Price], [Quantity], [Status], [FoodImage]) VALUES (1, N'1 bắp, 2 nước', N'Combo Optimus', 140000, 1, 1, N'optimusFood.jpg')
INSERT [dbo].[Food] ([FoodId], [Description], [FoodName], [Price], [Quantity], [Status], [FoodImage]) VALUES (2, N'1 bắp, 1 nước', N'Combo FA', 100000, 1, 1, N'FAFood.jpg')
INSERT [dbo].[Food] ([FoodId], [Description], [FoodName], [Price], [Quantity], [Status], [FoodImage]) VALUES (3, N'1 Coca', N'Cocacola', 50000, 1, 1, N'Pepsi.jpg')
INSERT [dbo].[Food] ([FoodId], [Description], [FoodName], [Price], [Quantity], [Status], [FoodImage]) VALUES (4, N'1 bắp', N'Bắp rang bơ', 50000, 1, 1, N'baprangbo.jpg')
SET IDENTITY_INSERT [dbo].[Food] OFF
GO
SET IDENTITY_INSERT [dbo].[Payment] ON 

INSERT [dbo].[Payment] ([PaymentId], [PaymentName], [Status]) VALUES (1, N'Ví Momo', 1)
INSERT [dbo].[Payment] ([PaymentId], [PaymentName], [Status]) VALUES (2, N'Ví VNPay', 1)
INSERT [dbo].[Payment] ([PaymentId], [PaymentName], [Status]) VALUES (3, N'Tiền mặt', 1)
SET IDENTITY_INSERT [dbo].[Payment] OFF
GO
SET IDENTITY_INSERT [dbo].[Producer] ON 

INSERT [dbo].[Producer] ([ProducerId], [ProducerName], [Status]) VALUES (1, N'Lý Hải', 1)
INSERT [dbo].[Producer] ([ProducerId], [ProducerName], [Status]) VALUES (2, N'Trấn Thành', 1)
INSERT [dbo].[Producer] ([ProducerId], [ProducerName], [Status]) VALUES (3, N'Tấn Hiếu', 1)
INSERT [dbo].[Producer] ([ProducerId], [ProducerName], [Status]) VALUES (4, N'Shin-Ei Animation', 1)
INSERT [dbo].[Producer] ([ProducerId], [ProducerName], [Status]) VALUES (5, N'Tiên Hoàng', 1)
INSERT [dbo].[Producer] ([ProducerId], [ProducerName], [Status]) VALUES (6, N'Mẩn Đạt', 1)
SET IDENTITY_INSERT [dbo].[Producer] OFF
GO
SET IDENTITY_INSERT [dbo].[ProducerOfFilm] ON 

INSERT [dbo].[ProducerOfFilm] ([ProducerOfFilmId], [FilmDetailId], [ProducerId]) VALUES (1, 1, 1)
INSERT [dbo].[ProducerOfFilm] ([ProducerOfFilmId], [FilmDetailId], [ProducerId]) VALUES (2, 2, 3)
INSERT [dbo].[ProducerOfFilm] ([ProducerOfFilmId], [FilmDetailId], [ProducerId]) VALUES (3, 3, 2)
INSERT [dbo].[ProducerOfFilm] ([ProducerOfFilmId], [FilmDetailId], [ProducerId]) VALUES (4, 4, 4)
INSERT [dbo].[ProducerOfFilm] ([ProducerOfFilmId], [FilmDetailId], [ProducerId]) VALUES (5, 5, 5)
INSERT [dbo].[ProducerOfFilm] ([ProducerOfFilmId], [FilmDetailId], [ProducerId]) VALUES (6, 6, 6)
SET IDENTITY_INSERT [dbo].[ProducerOfFilm] OFF
GO
SET IDENTITY_INSERT [dbo].[SeatLocation] ON 

INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (1, N'A1', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (2, N'A2', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (3, N'A3', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (4, N'A4', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (5, N'A5', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (6, N'A6', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (7, N'A7', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (8, N'A8', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (9, N'B1', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (10, N'B2', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (11, N'B3', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (12, N'B4', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (13, N'B5', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (14, N'B6', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (15, N'B7', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (16, N'B8', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (17, N'C1', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (18, N'C2', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (19, N'C3', 1, 2)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (20, N'C4', 1, 2)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (21, N'C5', 1, 2)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (22, N'C6', 1, 2)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (23, N'C7', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (24, N'C8', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (25, N'D1', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (26, N'D2', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (27, N'D3', 1, 2)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (28, N'D4', 1, 2)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (29, N'D5', 1, 2)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (30, N'D6', 1, 2)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (31, N'D7', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (32, N'D8', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (33, N'E1', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (34, N'E2', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (35, N'E3', 1, 2)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (36, N'E4', 1, 2)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (37, N'E5', 1, 2)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (38, N'E6', 1, 2)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (39, N'E7', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (40, N'E8', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (41, N'F1', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (42, N'F2', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (43, N'F3', 1, 2)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (44, N'F4', 1, 2)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (45, N'F5', 1, 2)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (46, N'F6', 1, 2)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (47, N'F7', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (48, N'F8', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (49, N'G1', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (50, N'G2', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (51, N'G3', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (52, N'G4', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (53, N'G5', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (54, N'G6', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (55, N'G7', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (56, N'G8', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (57, N'H1', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (58, N'H2', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (59, N'H3', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (60, N'H4', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (61, N'H5', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (62, N'H6', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (63, N'H7', 1, 1)
INSERT [dbo].[SeatLocation] ([SeatLocationId], [SeatNumber], [Status], [SeatTypeId]) VALUES (64, N'H8', 1, 1)
SET IDENTITY_INSERT [dbo].[SeatLocation] OFF
GO
SET IDENTITY_INSERT [dbo].[SeatType] ON 

INSERT [dbo].[SeatType] ([SeatTypeId], [Price], [SeatTypeName], [Status]) VALUES (1, 1, N'Ghế thường', 1)
INSERT [dbo].[SeatType] ([SeatTypeId], [Price], [SeatTypeName], [Status]) VALUES (2, 1.3, N'Ghế VIP', 1)
SET IDENTITY_INSERT [dbo].[SeatType] OFF
GO
SET IDENTITY_INSERT [dbo].[ShowTime] ON 

INSERT [dbo].[ShowTime] ([ShowTimeId], [Price], [ShowTimeDate], [Status], [FilmId], [ShowTimeListId]) VALUES (2, 1, CAST(N'2024-05-20' AS Date), 1, 1, 1)
INSERT [dbo].[ShowTime] ([ShowTimeId], [Price], [ShowTimeDate], [Status], [FilmId], [ShowTimeListId]) VALUES (3, 1, CAST(N'2024-05-20' AS Date), 1, 1, 2)
INSERT [dbo].[ShowTime] ([ShowTimeId], [Price], [ShowTimeDate], [Status], [FilmId], [ShowTimeListId]) VALUES (4, 1, CAST(N'2024-05-20' AS Date), 1, 1, 3)
INSERT [dbo].[ShowTime] ([ShowTimeId], [Price], [ShowTimeDate], [Status], [FilmId], [ShowTimeListId]) VALUES (5, 1, CAST(N'2024-05-20' AS Date), 1, 1, 4)
INSERT [dbo].[ShowTime] ([ShowTimeId], [Price], [ShowTimeDate], [Status], [FilmId], [ShowTimeListId]) VALUES (6, 1, CAST(N'2024-05-20' AS Date), 1, 1, 6)
INSERT [dbo].[ShowTime] ([ShowTimeId], [Price], [ShowTimeDate], [Status], [FilmId], [ShowTimeListId]) VALUES (7, 1, CAST(N'2024-05-20' AS Date), 1, 1, 10)
INSERT [dbo].[ShowTime] ([ShowTimeId], [Price], [ShowTimeDate], [Status], [FilmId], [ShowTimeListId]) VALUES (8, 1, CAST(N'2024-05-20' AS Date), 1, 1, 22)
INSERT [dbo].[ShowTime] ([ShowTimeId], [Price], [ShowTimeDate], [Status], [FilmId], [ShowTimeListId]) VALUES (9, 1, CAST(N'2024-05-20' AS Date), 1, 1, 25)
INSERT [dbo].[ShowTime] ([ShowTimeId], [Price], [ShowTimeDate], [Status], [FilmId], [ShowTimeListId]) VALUES (10, 1, CAST(N'2024-05-21' AS Date), 1, 2, 16)
INSERT [dbo].[ShowTime] ([ShowTimeId], [Price], [ShowTimeDate], [Status], [FilmId], [ShowTimeListId]) VALUES (11, 1, CAST(N'2024-05-21' AS Date), 1, 2, 12)
INSERT [dbo].[ShowTime] ([ShowTimeId], [Price], [ShowTimeDate], [Status], [FilmId], [ShowTimeListId]) VALUES (12, 1, CAST(N'2024-05-21' AS Date), 1, 2, 42)
INSERT [dbo].[ShowTime] ([ShowTimeId], [Price], [ShowTimeDate], [Status], [FilmId], [ShowTimeListId]) VALUES (13, 1, CAST(N'2024-05-21' AS Date), 1, 2, 21)
INSERT [dbo].[ShowTime] ([ShowTimeId], [Price], [ShowTimeDate], [Status], [FilmId], [ShowTimeListId]) VALUES (14, 1, CAST(N'2024-05-22' AS Date), 1, 1, 35)
INSERT [dbo].[ShowTime] ([ShowTimeId], [Price], [ShowTimeDate], [Status], [FilmId], [ShowTimeListId]) VALUES (15, 1, CAST(N'2024-05-22' AS Date), 1, 1, 14)
INSERT [dbo].[ShowTime] ([ShowTimeId], [Price], [ShowTimeDate], [Status], [FilmId], [ShowTimeListId]) VALUES (16, 1, CAST(N'2024-05-22' AS Date), 1, 1, 26)
SET IDENTITY_INSERT [dbo].[ShowTime] OFF
GO
SET IDENTITY_INSERT [dbo].[ShowTimeList] ON 

INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (1, N'8:00 - 11:00', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (2, N'8:15 - 11:15', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (3, N'8:30 - 11:30', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (4, N'8:45 - 11:45', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (5, N'9:00 - 12:00', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (6, N'9:15 - 12:15', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (7, N'9:30 - 12:30', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (8, N'10:45 - 12:45', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (9, N'10:00 - 13:00', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (10, N'10:15 - 13:15', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (11, N'10:30 - 13:30', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (12, N'10:45 - 13:45', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (13, N'11:00 - 14:00', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (14, N'11:15 - 14:15', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (15, N'11:30 - 14:30', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (16, N'11:45 - 14:45', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (17, N'12:00 - 15:00', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (18, N'12:15 - 15:15', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (19, N'12:30 - 15:30', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (20, N'12:45 - 15:45', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (21, N'13:00 - 16:00', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (22, N'13:15 - 16:15', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (23, N'13:30 - 16:30', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (24, N'13:45 - 16:45', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (25, N'14:00 - 17:00', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (26, N'14:15 - 17:15', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (27, N'14:30 - 17:30', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (28, N'14:45 - 17:45', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (29, N'15:00 - 18:00', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (30, N'15:15 - 18:15', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (31, N'15:30 - 18:30', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (32, N'15:45 - 18:45', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (33, N'16:00 - 19:00', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (34, N'16:15 - 19:15', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (35, N'16:30 - 19:30', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (36, N'16:45 - 19:45', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (37, N'17:00 - 20:00', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (38, N'17:15 - 20:15', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (39, N'17:30 - 20:30', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (40, N'17:45 - 20:45', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (41, N'18:00 - 21:00', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (42, N'18:15 - 21:15', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (43, N'18:30 - 21:30', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (44, N'18:45 - 21:45', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (45, N'19:00 - 22:00', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (46, N'19:15 - 22:15', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (47, N'19:30 - 22:30', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (48, N'19:45 - 22:45', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (49, N'20:00 - 23:00', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (50, N'20:15 - 23:15', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (51, N'20:30 - 23:30', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (52, N'20:45 - 23:45', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (53, N'21:00 - 00:00', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (54, N'21:15 - 00:15', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (55, N'21:30 - 00:30', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (56, N'21:45 - 00:45', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (57, N'22:00 - 01:00', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (58, N'22:15 - 01:15', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (59, N'22:30 - 01:30', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (60, N'22:45 - 01:45', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (61, N'23:00 - 02:00', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (62, N'23:15 - 02:15', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (63, N'23:30 - 02:30', 1)
INSERT [dbo].[ShowTimeList] ([ShowTimeListId], [ShowTimeFrame], [Status]) VALUES (64, N'23:45 - 02:45', 1)
SET IDENTITY_INSERT [dbo].[ShowTimeList] OFF
GO
SET IDENTITY_INSERT [dbo].[ShowTimeSeatType] ON 

INSERT [dbo].[ShowTimeSeatType] ([ShowTimeSeatTypeId], [Price], [SeatTypeId], [ShowTimeId]) VALUES (1, 1, 1, 2)
INSERT [dbo].[ShowTimeSeatType] ([ShowTimeSeatTypeId], [Price], [SeatTypeId], [ShowTimeId]) VALUES (2, 1.3, 2, 2)
INSERT [dbo].[ShowTimeSeatType] ([ShowTimeSeatTypeId], [Price], [SeatTypeId], [ShowTimeId]) VALUES (3, 1.3, 2, 3)
INSERT [dbo].[ShowTimeSeatType] ([ShowTimeSeatTypeId], [Price], [SeatTypeId], [ShowTimeId]) VALUES (4, 1.3, 2, 2)
INSERT [dbo].[ShowTimeSeatType] ([ShowTimeSeatTypeId], [Price], [SeatTypeId], [ShowTimeId]) VALUES (5, 1.3, 2, 2)
INSERT [dbo].[ShowTimeSeatType] ([ShowTimeSeatTypeId], [Price], [SeatTypeId], [ShowTimeId]) VALUES (6, 1.3, 2, 3)
INSERT [dbo].[ShowTimeSeatType] ([ShowTimeSeatTypeId], [Price], [SeatTypeId], [ShowTimeId]) VALUES (7, 1.3, 2, 2)
INSERT [dbo].[ShowTimeSeatType] ([ShowTimeSeatTypeId], [Price], [SeatTypeId], [ShowTimeId]) VALUES (8, 1, 1, 3)
INSERT [dbo].[ShowTimeSeatType] ([ShowTimeSeatTypeId], [Price], [SeatTypeId], [ShowTimeId]) VALUES (9, 1, 1, 3)
INSERT [dbo].[ShowTimeSeatType] ([ShowTimeSeatTypeId], [Price], [SeatTypeId], [ShowTimeId]) VALUES (10, 1, 1, 3)
INSERT [dbo].[ShowTimeSeatType] ([ShowTimeSeatTypeId], [Price], [SeatTypeId], [ShowTimeId]) VALUES (11, 1, 1, 3)
INSERT [dbo].[ShowTimeSeatType] ([ShowTimeSeatTypeId], [Price], [SeatTypeId], [ShowTimeId]) VALUES (12, 1, 1, 2)
INSERT [dbo].[ShowTimeSeatType] ([ShowTimeSeatTypeId], [Price], [SeatTypeId], [ShowTimeId]) VALUES (13, 1, 1, 2)
SET IDENTITY_INSERT [dbo].[ShowTimeSeatType] OFF
GO
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([UserId], [Birthdate], [Email], [FirstName], [LastName], [Password], [PhoneNumber], [Role], [Sex], [Status], [Username]) VALUES (1, CAST(N'2001-01-01' AS Date), N'anv01@gmail.com', N'A', N'Nguyễn', N'anv123                                                      ', N'0112441224', 1, 1, 1, N'anv001')
INSERT [dbo].[Users] ([UserId], [Birthdate], [Email], [FirstName], [LastName], [Password], [PhoneNumber], [Role], [Sex], [Status], [Username]) VALUES (2, CAST(N'2001-01-01' AS Date), N'anv02@gmail.com', N'A', N'Nguyễn', N'anv123                                                      ', N'0221647912', 1, 1, 1, N'anv002')
INSERT [dbo].[Users] ([UserId], [Birthdate], [Email], [FirstName], [LastName], [Password], [PhoneNumber], [Role], [Sex], [Status], [Username]) VALUES (3, CAST(N'2001-01-01' AS Date), N'anv03@gmail.com', N'A', N'Nguyễn', N'anv123                                                      ', N'0974563484', 1, 1, 1, N'anv003')
INSERT [dbo].[Users] ([UserId], [Birthdate], [Email], [FirstName], [LastName], [Password], [PhoneNumber], [Role], [Sex], [Status], [Username]) VALUES (4, CAST(N'2001-01-01' AS Date), N'anv04@gmail.com', N'A', N'Nguyễn', N'anv123                                                      ', N'0344985531', 1, 1, 1, N'anv004')
INSERT [dbo].[Users] ([UserId], [Birthdate], [Email], [FirstName], [LastName], [Password], [PhoneNumber], [Role], [Sex], [Status], [Username]) VALUES (5, CAST(N'2001-01-01' AS Date), N'anv05@gmail.com', N'A', N'Nguyễn', N'anv123                                                      ', N'0223111548', 1, 1, 1, N'anv005')
INSERT [dbo].[Users] ([UserId], [Birthdate], [Email], [FirstName], [LastName], [Password], [PhoneNumber], [Role], [Sex], [Status], [Username]) VALUES (6, CAST(N'2001-01-01' AS Date), N'anv06@gmail.com', N'A', N'Nguyễn', N'anv123                                                      ', N'0669874513', 1, 1, 1, N'anv006')
INSERT [dbo].[Users] ([UserId], [Birthdate], [Email], [FirstName], [LastName], [Password], [PhoneNumber], [Role], [Sex], [Status], [Username]) VALUES (8, NULL, N'lnpbao15@gmail.com', NULL, NULL, N'$2a$10$JaILe6oSkFFPi4iqb90Fj.oq5nlDF2ApAN0lNos/HMwVxOUP8Wcl6', NULL, 0, 0, 0, N'bao')
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
ALTER TABLE [dbo].[ActorOfFilm]  WITH CHECK ADD  CONSTRAINT [FK1ykx6tbq9ocaai10k87q9nnli] FOREIGN KEY([ActorId])
REFERENCES [dbo].[Actor] ([ActorId])
GO
ALTER TABLE [dbo].[ActorOfFilm] CHECK CONSTRAINT [FK1ykx6tbq9ocaai10k87q9nnli]
GO
ALTER TABLE [dbo].[ActorOfFilm]  WITH CHECK ADD  CONSTRAINT [FKs0fpkuarw4fyt0fmb68v00bc3] FOREIGN KEY([FilmDetailId])
REFERENCES [dbo].[FilmDetail] ([FilmDetailId])
GO
ALTER TABLE [dbo].[ActorOfFilm] CHECK CONSTRAINT [FKs0fpkuarw4fyt0fmb68v00bc3]
GO
ALTER TABLE [dbo].[CinemaRoom]  WITH CHECK ADD  CONSTRAINT [FK1mydony2ilkcnel9bk76chh3t] FOREIGN KEY([SeatLocationId])
REFERENCES [dbo].[SeatLocation] ([SeatLocationId])
GO
ALTER TABLE [dbo].[CinemaRoom] CHECK CONSTRAINT [FK1mydony2ilkcnel9bk76chh3t]
GO
ALTER TABLE [dbo].[CinemaRoom]  WITH CHECK ADD  CONSTRAINT [FK1vk0kw8ko59fcv468o19rgvct] FOREIGN KEY([ShowTimeId])
REFERENCES [dbo].[ShowTime] ([ShowTimeId])
GO
ALTER TABLE [dbo].[CinemaRoom] CHECK CONSTRAINT [FK1vk0kw8ko59fcv468o19rgvct]
GO
ALTER TABLE [dbo].[DirectorOfFilm]  WITH CHECK ADD  CONSTRAINT [FKfchst21chx8lqbn7o4u93wdeh] FOREIGN KEY([DirectorId])
REFERENCES [dbo].[Director] ([DirectorId])
GO
ALTER TABLE [dbo].[DirectorOfFilm] CHECK CONSTRAINT [FKfchst21chx8lqbn7o4u93wdeh]
GO
ALTER TABLE [dbo].[DirectorOfFilm]  WITH CHECK ADD  CONSTRAINT [FKhhetruosxveuif093qu3gok3h] FOREIGN KEY([FilmDetailId])
REFERENCES [dbo].[FilmDetail] ([FilmDetailId])
GO
ALTER TABLE [dbo].[DirectorOfFilm] CHECK CONSTRAINT [FKhhetruosxveuif093qu3gok3h]
GO
ALTER TABLE [dbo].[Film]  WITH CHECK ADD  CONSTRAINT [FKptxx5iilnq320fcm9apamoypb] FOREIGN KEY([CountryId])
REFERENCES [dbo].[Country] ([CountryId])
GO
ALTER TABLE [dbo].[Film] CHECK CONSTRAINT [FKptxx5iilnq320fcm9apamoypb]
GO
ALTER TABLE [dbo].[FilmDetail]  WITH CHECK ADD  CONSTRAINT [FKiu57yh5faegd8vrk6t6gaah86] FOREIGN KEY([FilmId])
REFERENCES [dbo].[Film] ([FilmId])
GO
ALTER TABLE [dbo].[FilmDetail] CHECK CONSTRAINT [FKiu57yh5faegd8vrk6t6gaah86]
GO
ALTER TABLE [dbo].[FilmGenres]  WITH CHECK ADD  CONSTRAINT [FKg1u1mlwgws3ulo9ecxh9bf8g1] FOREIGN KEY([FilmId])
REFERENCES [dbo].[Film] ([FilmId])
GO
ALTER TABLE [dbo].[FilmGenres] CHECK CONSTRAINT [FKg1u1mlwgws3ulo9ecxh9bf8g1]
GO
ALTER TABLE [dbo].[FilmGenres]  WITH CHECK ADD  CONSTRAINT [FKsxpww56la1bc2yainq1x555ah] FOREIGN KEY([FilmTypeId])
REFERENCES [dbo].[FilmType] ([FilmTypeId])
GO
ALTER TABLE [dbo].[FilmGenres] CHECK CONSTRAINT [FKsxpww56la1bc2yainq1x555ah]
GO
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [FKetqu5y167m0yweid08ras6d7d] FOREIGN KEY([VoucherId])
REFERENCES [dbo].[Voucher] ([VoucherId])
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [FKetqu5y167m0yweid08ras6d7d]
GO
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [FKp50vunrhhkl6da5okyf7qgkry] FOREIGN KEY([PaymentId])
REFERENCES [dbo].[Payment] ([PaymentId])
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [FKp50vunrhhkl6da5okyf7qgkry]
GO
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [FKhfvoq26re1o3k1wytmuhhym6] FOREIGN KEY([UserId])
REFERENCES [dbo].[Users] ([UserId])
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [FKhfvoq26re1o3k1wytmuhhym6]
GO
ALTER TABLE [dbo].[InvoiceDetail]  WITH CHECK ADD  CONSTRAINT [FK6byprgvyc87etiaot8tqc14rj] FOREIGN KEY([SeatLocationId])
REFERENCES [dbo].[SeatLocation] ([SeatLocationId])
GO
ALTER TABLE [dbo].[InvoiceDetail] CHECK CONSTRAINT [FK6byprgvyc87etiaot8tqc14rj]
GO
ALTER TABLE [dbo].[InvoiceDetail]  WITH CHECK ADD  CONSTRAINT [FK6s6klrfavswileao1xm6u7sdp] FOREIGN KEY([InvoiceId])
REFERENCES [dbo].[Invoice] ([InvoiceId])
GO
ALTER TABLE [dbo].[InvoiceDetail] CHECK CONSTRAINT [FK6s6klrfavswileao1xm6u7sdp]
GO
ALTER TABLE [dbo].[InvoiceDetail]  WITH CHECK ADD  CONSTRAINT [FKsheducqo7v3wbb1hd3caojno1] FOREIGN KEY([ShowTimeId])
REFERENCES [dbo].[ShowTime] ([ShowTimeId])
GO
ALTER TABLE [dbo].[InvoiceDetail] CHECK CONSTRAINT [FKsheducqo7v3wbb1hd3caojno1]
GO
ALTER TABLE [dbo].[OrderFood]  WITH CHECK ADD  CONSTRAINT [FK8g7gpnhjgra66m9jpv11cl4ak] FOREIGN KEY([InvoiceId])
REFERENCES [dbo].[Invoice] ([InvoiceId])
GO
ALTER TABLE [dbo].[OrderFood] CHECK CONSTRAINT [FK8g7gpnhjgra66m9jpv11cl4ak]
GO
ALTER TABLE [dbo].[OrderFood]  WITH CHECK ADD  CONSTRAINT [FKol6l5hrbjmqobnwsrd7wbja55] FOREIGN KEY([FoodId])
REFERENCES [dbo].[Food] ([FoodId])
GO
ALTER TABLE [dbo].[OrderFood] CHECK CONSTRAINT [FKol6l5hrbjmqobnwsrd7wbja55]
GO
ALTER TABLE [dbo].[ProducerOfFilm]  WITH CHECK ADD  CONSTRAINT [FKjlv6muydjr1xot3dprldwhoo2] FOREIGN KEY([ProducerId])
REFERENCES [dbo].[Producer] ([ProducerId])
GO
ALTER TABLE [dbo].[ProducerOfFilm] CHECK CONSTRAINT [FKjlv6muydjr1xot3dprldwhoo2]
GO
ALTER TABLE [dbo].[ProducerOfFilm]  WITH CHECK ADD  CONSTRAINT [FKr7l8r63s8joorbyv0fm9ypog3] FOREIGN KEY([FilmDetailId])
REFERENCES [dbo].[FilmDetail] ([FilmDetailId])
GO
ALTER TABLE [dbo].[ProducerOfFilm] CHECK CONSTRAINT [FKr7l8r63s8joorbyv0fm9ypog3]
GO
ALTER TABLE [dbo].[SeatLocation]  WITH CHECK ADD  CONSTRAINT [FKj8ixdxkpap3bgl0eph95wc2d2] FOREIGN KEY([SeatTypeId])
REFERENCES [dbo].[SeatType] ([SeatTypeId])
GO
ALTER TABLE [dbo].[SeatLocation] CHECK CONSTRAINT [FKj8ixdxkpap3bgl0eph95wc2d2]
GO
ALTER TABLE [dbo].[ShowTime]  WITH CHECK ADD  CONSTRAINT [FKfmbmv5uj77w8482d7ka0ft2mf] FOREIGN KEY([ShowTimeListId])
REFERENCES [dbo].[ShowTimeList] ([ShowTimeListId])
GO
ALTER TABLE [dbo].[ShowTime] CHECK CONSTRAINT [FKfmbmv5uj77w8482d7ka0ft2mf]
GO
ALTER TABLE [dbo].[ShowTime]  WITH CHECK ADD  CONSTRAINT [FKj14lsrr7qutxqh790urlqbdfo] FOREIGN KEY([FilmId])
REFERENCES [dbo].[Film] ([FilmId])
GO
ALTER TABLE [dbo].[ShowTime] CHECK CONSTRAINT [FKj14lsrr7qutxqh790urlqbdfo]
GO
ALTER TABLE [dbo].[ShowTimeSeatType]  WITH CHECK ADD  CONSTRAINT [FKn3tjbgs6knqdpnrov1bqs1dej] FOREIGN KEY([SeatTypeId])
REFERENCES [dbo].[SeatType] ([SeatTypeId])
GO
ALTER TABLE [dbo].[ShowTimeSeatType] CHECK CONSTRAINT [FKn3tjbgs6knqdpnrov1bqs1dej]
GO
ALTER TABLE [dbo].[ShowTimeSeatType]  WITH CHECK ADD  CONSTRAINT [FKsyvbi9hsc7bfhtlmu8xtf9dva] FOREIGN KEY([ShowTimeId])
REFERENCES [dbo].[ShowTime] ([ShowTimeId])
GO
ALTER TABLE [dbo].[ShowTimeSeatType] CHECK CONSTRAINT [FKsyvbi9hsc7bfhtlmu8xtf9dva]
GO
