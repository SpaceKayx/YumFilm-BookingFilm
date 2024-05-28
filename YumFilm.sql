USE [YumFilm]
GO
/****** Object:  Table [dbo].[Actor]    Script Date: 5/28/2024 1:56:20 PM ******/
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
/****** Object:  Table [dbo].[ActorOfFilm]    Script Date: 5/28/2024 1:56:20 PM ******/
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
/****** Object:  Table [dbo].[CinemaRoom]    Script Date: 5/28/2024 1:56:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CinemaRoom](
	[CinemaRoom] [int] IDENTITY(1,1) NOT NULL,
	[NameRoom] [nvarchar](50) NOT NULL,
	[Status] [bit] NOT NULL,
	[SeatLocationId] [int] NULL,
	[ShowTimeId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[CinemaRoom] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Country]    Script Date: 5/28/2024 1:56:20 PM ******/
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
/****** Object:  Table [dbo].[Director]    Script Date: 5/28/2024 1:56:20 PM ******/
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
/****** Object:  Table [dbo].[DirectorOfFilm]    Script Date: 5/28/2024 1:56:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DirectorOfFilm](
	[DirectorOfFilmId] [int] IDENTITY(1,1) NOT NULL,
	[DirectorId] [int] NOT NULL,
	[FilmId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[DirectorOfFilmId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Film]    Script Date: 5/28/2024 1:56:20 PM ******/
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
PRIMARY KEY CLUSTERED 
(
	[FilmId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[FilmDetail]    Script Date: 5/28/2024 1:56:20 PM ******/
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
/****** Object:  Table [dbo].[FilmGenres]    Script Date: 5/28/2024 1:56:20 PM ******/
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
/****** Object:  Table [dbo].[FilmType]    Script Date: 5/28/2024 1:56:20 PM ******/
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
/****** Object:  Table [dbo].[Food]    Script Date: 5/28/2024 1:56:20 PM ******/
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
PRIMARY KEY CLUSTERED 
(
	[FoodId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Invoice]    Script Date: 5/28/2024 1:56:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Invoice](
	[InvoiceId] [bigint] IDENTITY(1,1) NOT NULL,
	[CreateDate] [datetime] NOT NULL,
	[Note] [nvarchar](255) NOT NULL,
	[PaymentStatus] [bit] NOT NULL,
	[Status] [bit] NOT NULL,
	[Total] [float] NOT NULL,
	[PaymentId] [int] NULL,
	[UserId] [bigint] NULL,
	[VoucherId] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[InvoiceId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[InvoiceDetail]    Script Date: 5/28/2024 1:56:20 PM ******/
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
/****** Object:  Table [dbo].[OrderFood]    Script Date: 5/28/2024 1:56:20 PM ******/
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
/****** Object:  Table [dbo].[Payment]    Script Date: 5/28/2024 1:56:20 PM ******/
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
/****** Object:  Table [dbo].[Producer]    Script Date: 5/28/2024 1:56:20 PM ******/
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
/****** Object:  Table [dbo].[ProducerOfFilm]    Script Date: 5/28/2024 1:56:20 PM ******/
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
/****** Object:  Table [dbo].[SeatLocation]    Script Date: 5/28/2024 1:56:20 PM ******/
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
/****** Object:  Table [dbo].[SeatType]    Script Date: 5/28/2024 1:56:20 PM ******/
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
/****** Object:  Table [dbo].[ShowTime]    Script Date: 5/28/2024 1:56:20 PM ******/
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
/****** Object:  Table [dbo].[ShowTimeList]    Script Date: 5/28/2024 1:56:20 PM ******/
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
/****** Object:  Table [dbo].[ShowTimeSeatType]    Script Date: 5/28/2024 1:56:20 PM ******/
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
/****** Object:  Table [dbo].[Users]    Script Date: 5/28/2024 1:56:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[UserId] [bigint] IDENTITY(1,1) NOT NULL,
	[Birthdate] [date] NOT NULL,
	[Email] [nvarchar](255) NOT NULL,
	[FirstName] [nvarchar](50) NOT NULL,
	[LastName] [nvarchar](50) NOT NULL,
	[Password] [nchar](60) NOT NULL,
	[PhoneNumber] [nvarchar](50) NOT NULL,
	[Role] [bit] NOT NULL,
	[Sex] [bit] NOT NULL,
	[Status] [bit] NOT NULL,
	[Username] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Voucher]    Script Date: 5/28/2024 1:56:20 PM ******/
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
SET IDENTITY_INSERT [dbo].[ActorOfFilm] OFF
GO
INSERT [dbo].[Country] ([CountryId], [CountryName], [Status]) VALUES (N'VN', N'Việt Nam', 1)
GO
SET IDENTITY_INSERT [dbo].[Film] ON 

INSERT [dbo].[Film] ([FilmId], [FilmImage], [FilmName], [FilmTime], [PremiereDate], [Price], [Status], [VideoTrailer], [CountryId]) VALUES (1, N'latmat7.png', N'Lật Mật 7', N'2 giờ 18 phút', CAST(N'2024-04-26' AS Date), 100000, 1, N'latmat7', N'VN')
SET IDENTITY_INSERT [dbo].[Film] OFF
GO
SET IDENTITY_INSERT [dbo].[FilmDetail] ON 

INSERT [dbo].[FilmDetail] ([FilmDetailId], [Description], [ProductionDate], [Status], [FilmId]) VALUES (1, N'Một câu chuyện lần đầu được kể bằng tất cả tình yêu, và từ tất cả những hồi ức xao xuyến nhất của đấng sinh thành', CAST(N'2024-04-26' AS Date), 1, 1)
SET IDENTITY_INSERT [dbo].[FilmDetail] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UK23y4gd49ajvbqgl3psjsvhff6]    Script Date: 5/28/2024 1:56:20 PM ******/
ALTER TABLE [dbo].[Users] ADD  CONSTRAINT [UK23y4gd49ajvbqgl3psjsvhff6] UNIQUE NONCLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
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
ALTER TABLE [dbo].[DirectorOfFilm]  WITH CHECK ADD  CONSTRAINT [FKhhetruosxveuif093qu3gok3h] FOREIGN KEY([FilmId])
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
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [FKhfvoq26re1o3k1wytmuhhym6] FOREIGN KEY([UserId])
REFERENCES [dbo].[Users] ([UserId])
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [FKhfvoq26re1o3k1wytmuhhym6]
GO
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [FKp50vunrhhkl6da5okyf7qgkry] FOREIGN KEY([PaymentId])
REFERENCES [dbo].[Payment] ([PaymentId])
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [FKp50vunrhhkl6da5okyf7qgkry]
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
