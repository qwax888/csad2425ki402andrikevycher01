def generate_upper_right_triangle_matrix():
    # Read the size of the square matrix from the user
    n = int(input("Enter the size of the square matrix: "))
    
    # Read the fill character from the user
    fill_char = input("Enter the fill character: ")
    
    # Check if only one character is entered
    if len(fill_char) != 1:
        print("Error: Entered more than one character.")
        return

    # Initialize a 2D list with spaces
    matrix = [[' ' for _ in range(n)] for _ in range(n)]

    # Fill the upper right triangle of the matrix with the fill character
    for i in range(n):
        for j in range(n - i):
            matrix[i][j + i] = fill_char

    # Print the generated matrix
    for row in matrix:
        print(' '.join(row))

if __name__ == "__main__":
    generate_upper_right_triangle_matrix()
