# Problem asked in Singapore airlines online test.
# For a given start and end position in a 8*8 chessboard. Determine if knight piece can reach from start to end in x moves. 

class ChessBoard:
	def __init__(self):
		self.w = 8
		self.h = 8

	#function to generate all legal moves for a start position - one move level only 
	def generate_legal_moves(self, cur_pos): 
		possible_pos = []
		#all possible move offsets
		move_offsets = [(1, 2), (1, -2), (-1, 2), (-1, -2),
                        (2, 1), (2, -1), (-2, 1), (-2, -1)]

		for move in move_offsets:
			new_x = cur_pos[0] + move[0]
			new_y = cur_pos[1] + move[1]

			if (new_x >= self.h):
				continue
			elif (new_x < 0):
				continue
			elif (new_y >= self.w):
				continue
			elif (new_y < 0):
				continue
			else:
				possible_pos.append((new_x, new_y))

		return possible_pos

	#main function which has the logic which will return if knight can reach end from start in x moves.
	#uses recurssion to achieve this
	def isMovePossible(self, x, start, end):
		if(x==0):												#check if we have moved x times and still havent found end position
			return False;
		else:
			list_moves=[]
			list_moves = self.generate_legal_moves(start)		#generate all positions for one move from start possition
			if((end in list_moves) and x==1):					#check if we have reached the position in x moves
				return True
			else:
				print(list_moves)
				for node in list_moves:								#else iterate the list and do recurssive call till we exhaust moves
					retval = self.isMovePossible(x-1, node, end)		
					if(retval):
						return True
					else:
						continue
			return False

if __name__ == '__main__':
	cb=ChessBoard()
	print(cb.isMovePossible(3,(3,4),(1,5)))