import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SortingVisualizer extends JPanel {
    private static final int ARRAY_SIZE = 100;
    private static final int MAX_HEIGHT = 400;
    private static final int BAR_GAP = 2;
    private int[] array;
    private int currentIndex = -1;
    private int nextIndex = -1;
    private JComboBox<String> algorithmSelector;
    private JLabel timerLabel;

    public SortingVisualizer() {
        array = new int[ARRAY_SIZE];
        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(MAX_HEIGHT);
        }

        algorithmSelector = new JComboBox<>(
                new String[] { "Bubble Sort", "Selection Sort", "Insertion Sort", "Merge Sort", "Quick Sort" });
        algorithmSelector.addActionListener(e -> new Thread(() -> {
            try {
                sort();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start());

        timerLabel = new JLabel("Time: 0 ms");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        int barWidth = (getWidth() - (ARRAY_SIZE - 1) * BAR_GAP) / ARRAY_SIZE;
        for (int i = 0; i < array.length; i++) {
            if (i == currentIndex) {
                g.setColor(Color.RED);
            } else if (i == nextIndex) {
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.BLACK);
            }
            int x = i * (barWidth + BAR_GAP);
            g.fillRect(x, getHeight() - array[i], barWidth, array[i]);
        }
    }

    private void sort() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        switch ((String) algorithmSelector.getSelectedItem()) {
            case "Bubble Sort":
                bubbleSort();
                break;
            case "Selection Sort":
                selectionSort();
                break;
            case "Insertion Sort":
                insertionSort();
                break;
            case "Merge Sort":
                mergeSort(0, array.length - 1);
                break;
            case "Quick Sort":
                quickSort(0, array.length - 1);
                break;
        }

        long endTime = System.currentTimeMillis();
        timerLabel.setText("Time: " + (endTime - startTime) + " ms");

        currentIndex = -1;
        nextIndex = -1;
        repaint();
    }

    private void bubbleSort() throws InterruptedException {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                currentIndex = j;
                nextIndex = j + 1;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                repaint();
                Thread.sleep(10);
            }
        }
    }

    private void selectionSort() throws InterruptedException {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                currentIndex = j;
                nextIndex = minIndex;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
                repaint();
                Thread.sleep(10);
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    private void insertionSort() throws InterruptedException {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                currentIndex = j;
                nextIndex = j + 1;
                array[j + 1] = array[j];
                repaint();
                Thread.sleep(10);
                j--;
            }
            array[j + 1] = key;
        }
    }

    private void mergeSort(int left, int right) throws InterruptedException {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) throws InterruptedException {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            currentIndex = left + i;
            nextIndex = mid + 1 + j;
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
            repaint();
            Thread.sleep(10);
        }

        while (i < n1) {
            currentIndex = left + i;
            array[k] = L[i];
            i++;
            k++;
            repaint();
            Thread.sleep(10);
        }

        while (j < n2) {
            nextIndex = mid + 1 + j;
            array[k] = R[j];
            j++;
            k++;
            repaint();
            Thread.sleep(10);
        }
    }

    private void quickSort(int low, int high) throws InterruptedException {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) throws InterruptedException {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            currentIndex = j;
            nextIndex = high;
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                repaint();
                Thread.sleep(10);
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        repaint();
        Thread.sleep(10);
        return i + 1;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Visualizer");
        SortingVisualizer visualizer = new SortingVisualizer();
        frame.setLayout(new BorderLayout());
        frame.add(visualizer, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(visualizer.algorithmSelector, BorderLayout.NORTH);
        controlPanel.add(visualizer.timerLabel, BorderLayout.SOUTH);

        frame.add(controlPanel, BorderLayout.NORTH);

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
