package com.bridgeLabs.indianStatesCensusAnalyserProgram;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.bridgeLabs.csvHandler.CsvException;
import com.bridgeLabs.csvHandler.CsvExceptionType;
import com.google.gson.Gson;

public class StateCensusAnalyserTest {
	public static final String RIGHT_CENSUS_CSV = "src/main/resources/India-Census-Data.csv";
	public static final String WRONG_CENSUS_CSV = "src/main/resources/India-Census-Date.csv";
	public static final String WRONGTYPE_CENSUS_CSV = "src/main/resources/India-Census-Data-WrongType.csv";
	public static final String WRONGDELIMITER_CENSUS_CSV = "src/main/resources/India-Census-Data-WrongDelimiter.csv";
	public static final String WRONGHEADER_CENSUS_CSV = "src/main/resources/India-Census-Data-WrongHeader.csv";
	public static final String RIGHT_STATE_CODES_CSV = "src/main/resources/India-State-Codes.csv";
	public static final String WRONG_STATE_CODES_CSV = "src/main/resources/India-Stata-Codes.csv";
	public static final String WRONGTYPE_STATE_CODES_CSV = "src/main/resources/India-State-Codes-WrongType.csv";
	public static final String WRONGDELIMITER_STATE_CODES_CSV = "src/main/resources/India-State-Codes-WrongDelimiter.csv";
	public static final String WRONGHEADER_STATE_CODES_CSV = "src/main/resources/India-State-Codes-WrongHeader.csv";

	@Test
	public void givenIndiaCensusDataCsvShouldReturnExactCount() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			int recordsCount = stateCensusAnalyser.loadStateCensusData(RIGHT_CENSUS_CSV, CsvBuilderType.OPEN_CSV)
					.size();
			Assert.assertEquals(28, recordsCount);
		} catch (CsvException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void givenWrongIndiaCensusCsvFileShouldThrowCensusAnalyserExceptionOfTypeCensusFileProblem() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.loadStateCensusData(WRONG_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.CENSUS_FILE_PROBLEM, e.exceptionType);
		}
	}

	@Test
	public void givenWrongTypeIndiaCensusCsvFileShouldThrowCensusAnalyserExceptionOfTypeIncorrectType() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.loadStateCensusData(WRONGTYPE_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_TYPE, e.exceptionType);
		}
	}

	@Test
	public void givenIndiaCensusCsvFileIncorrectDelimiterShouldThrowCensusAnalyserExceptionOfTypeIncorrectDelimiter() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.loadStateCensusData(WRONGDELIMITER_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_DELIMITER, e.exceptionType);
		}
	}

	@Test
	public void givenIndiaCensusCsvFileIncorrectHeaderShouldThrowCensusAnalyserExceptionOfTypeIncorrectHeader() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.loadStateCensusData(WRONGHEADER_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_HEADER, e.exceptionType);
		}
	}

	@Test
	public void givenIndiaStateCodesCsvShouldReturnExactCount() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			int recordsCount = stateCensusAnalyser.loadStateCodesData(RIGHT_STATE_CODES_CSV, CsvBuilderType.OPEN_CSV)
					.size();
			Assert.assertEquals(32, recordsCount);
		} catch (CsvException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void givenWrongStateCodeCsvFileShouldThrowCensusAnalyserExceptionOfTypeCensusFileProblem() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.loadStateCodesData(WRONG_STATE_CODES_CSV, CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.CENSUS_FILE_PROBLEM, e.exceptionType);
		}
	}

	@Test
	public void givenWrongTypeStateCodeCsvFileShouldThrowCensusAnalyserExceptionOfTypeIncorrectType() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.loadStateCodesData(WRONGTYPE_STATE_CODES_CSV, CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_TYPE, e.exceptionType);
		}
	}

	@Test
	public void givenStateCodesCsvFileIncorrectDelimiterShouldThrowCensusAnalyserExceptionOfTypeIncorrectDelimiter() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.loadStateCodesData(WRONGDELIMITER_STATE_CODES_CSV, CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_DELIMITER, e.exceptionType);
		}
	}

	@Test
	public void givenStateCodesCsvFileIncorrectHeaderShouldThrowCensusAnalyserExceptionOfTypeIncorrectHeader() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.loadStateCodesData(WRONGHEADER_STATE_CODES_CSV, CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_HEADER, e.exceptionType);
		}
	}

	@Test
	public void givenIndianCensusDataWhenSortedOnStateShouldReturnSortedResult() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			String sortedStateCensusJson = stateCensusAnalyser.getStateWiseSortedCensusData(RIGHT_CENSUS_CSV,
					CsvBuilderType.OPEN_CSV);
			CSVStateCensus[] censusCsv = new Gson().fromJson(sortedStateCensusJson, CSVStateCensus[].class);
			Assert.assertEquals("Andhra Pradesh", censusCsv[0].stateName);
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianCensusDataWhenSortedOnStateShouldReturnSortedResultWithCorrectLastState() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			String sortedStateCensusJson = stateCensusAnalyser.getStateWiseSortedCensusData(RIGHT_CENSUS_CSV,
					CsvBuilderType.OPEN_CSV);
			CSVStateCensus[] censusCsv = new Gson().fromJson(sortedStateCensusJson, CSVStateCensus[].class);
			Assert.assertEquals("West Bengal", censusCsv[censusCsv.length - 1].stateName);
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenWrongIndiaCensusCsvWhenSortedOnStateFileShouldThrowCensusAnalyserExceptionOfTypeCensusFileProblem() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getStateWiseSortedCensusData(WRONG_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.CENSUS_FILE_PROBLEM, e.exceptionType);
		}
	}

	@Test
	public void givenWrongTypeIndiaCensusCsvFileWhenSortedOnStateShouldThrowCensusAnalyserExceptionOfTypeIncorrectType() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getStateWiseSortedCensusData(WRONGTYPE_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_TYPE, e.exceptionType);
		}
	}

	@Test
	public void givenIndiaCensusCsvFileWhenSortedOnStateIncorrectDelimiterShouldThrowCensusAnalyserExceptionOfTypeIncorrectDelimiter() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getStateWiseSortedCensusData(WRONGDELIMITER_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_DELIMITER, e.exceptionType);
		}
	}

	@Test
	public void givenIndiaCensusCsvFileWhenSortedOnStateIncorrectHeaderShouldThrowCensusAnalyserExceptionOfTypeIncorrectHeader() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getStateWiseSortedCensusData(WRONGHEADER_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_HEADER, e.exceptionType);
		}
	}

	@Test
	public void givenIndianCensusDataWhenSortedOnStateCodeShouldReturnSortedResult() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			String sortedStateCensusJson = stateCensusAnalyser.getStateCodeWiseSortedCensusData(RIGHT_CENSUS_CSV,
					CsvBuilderType.OPEN_CSV);
			CSVStateCensus[] censusCsv = new Gson().fromJson(sortedStateCensusJson, CSVStateCensus[].class);
			Assert.assertEquals("Andhra Pradesh", censusCsv[0].stateName);
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianCensusDataWhenSortedOnStateCodeShouldReturnSortedResultWithCorrectLastState() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			String sortedStateCensusJson = stateCensusAnalyser.getStateCodeWiseSortedCensusData(RIGHT_CENSUS_CSV,
					CsvBuilderType.OPEN_CSV);
			CSVStateCensus[] censusCsv = new Gson().fromJson(sortedStateCensusJson, CSVStateCensus[].class);
			Assert.assertEquals("West Bengal", censusCsv[censusCsv.length - 1].stateName);
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenWrongIndiaCensusCsvWhenSortedOnStateCodeFileShouldThrowCensusAnalyserExceptionOfTypeCensusFileProblem() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getStateCodeWiseSortedCensusData(WRONG_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.CENSUS_FILE_PROBLEM, e.exceptionType);
		}
	}

	@Test
	public void givenWrongTypeIndiaCensusCsvFileWhenSortedOnStateCodeShouldThrowCensusAnalyserExceptionOfTypeIncorrectType() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getStateCodeWiseSortedCensusData(WRONGTYPE_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_TYPE, e.exceptionType);
		}
	}

	@Test
	public void givenIndiaCensusCsvFileWhenSortedOnStateCodeIncorrectDelimiterShouldThrowCensusAnalyserExceptionOfTypeIncorrectDelimiter() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getStateCodeWiseSortedCensusData(WRONGDELIMITER_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_DELIMITER, e.exceptionType);
		}
	}

	@Test
	public void givenIndiaCensusCsvFileWhenSortedOnStateCodeIncorrectHeaderShouldThrowCensusAnalyserExceptionOfTypeIncorrectHeader() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getStateCodeWiseSortedCensusData(WRONGHEADER_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_HEADER, e.exceptionType);
		}
	}

	@Test
	public void givenIndianCensusDataWhenSortedOnStatePopulationShouldReturnSortedResult() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			String sortedStateCensusJson = stateCensusAnalyser
					.getCensusDataFromMostPopulousStateToLeast(RIGHT_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
			CSVStateCensus[] censusCsv = new Gson().fromJson(sortedStateCensusJson, CSVStateCensus[].class);
			Assert.assertEquals("Uttar Pradesh", censusCsv[0].stateName);
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianCensusDataWhenSortedOnStatePopulationShouldReturnSortedResultWithCorrectLeastPopulousState() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			String sortedStateCensusJson = stateCensusAnalyser
					.getCensusDataFromMostPopulousStateToLeast(RIGHT_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
			CSVStateCensus[] censusCsv = new Gson().fromJson(sortedStateCensusJson, CSVStateCensus[].class);
			Assert.assertEquals("Sikkim", censusCsv[censusCsv.length - 1].stateName);
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenWrongIndiaCensusCsvWhenSortedOnStatePopulationFileShouldThrowCensusAnalyserExceptionOfTypeCensusFileProblem() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getCensusDataFromMostPopulousStateToLeast(WRONG_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.CENSUS_FILE_PROBLEM, e.exceptionType);
		}
	}

	@Test
	public void givenWrongTypeIndiaCensusCsvFileWhenSortedOnStatePopulationShouldThrowCensusAnalyserExceptionOfTypeIncorrectType() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getCensusDataFromMostPopulousStateToLeast(WRONGTYPE_CENSUS_CSV,
					CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_TYPE, e.exceptionType);
		}
	}

	@Test
	public void givenIndiaCensusCsvFileWhenSortedOnStatePopulationIncorrectDelimiterShouldThrowCensusAnalyserExceptionOfTypeIncorrectDelimiter() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getCensusDataFromMostPopulousStateToLeast(WRONGDELIMITER_CENSUS_CSV,
					CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_DELIMITER, e.exceptionType);
		}
	}

	@Test
	public void givenIndiaCensusCsvFileWhenSortedOnStatePopulationIncorrectHeaderShouldThrowCensusAnalyserExceptionOfTypeIncorrectHeader() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getCensusDataFromMostPopulousStateToLeast(WRONGHEADER_CENSUS_CSV,
					CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_HEADER, e.exceptionType);
		}
	}

	@Test
	public void givenIndianCensusDataWhenSortedOnStatePopulationDensityShouldReturnSortedResult() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			String sortedStateCensusJson = stateCensusAnalyser
					.getCensusDataFromMostDenslyPopulatedStateToLeast(RIGHT_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
			CSVStateCensus[] censusCsv = new Gson().fromJson(sortedStateCensusJson, CSVStateCensus[].class);
			Assert.assertEquals("Bihar", censusCsv[0].stateName);
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianCensusDataWhenSortedOnStatePopulationDensityShouldReturnSortedResultWithCorrectLeastDenslyPopulatedState() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			String sortedStateCensusJson = stateCensusAnalyser
					.getCensusDataFromMostDenslyPopulatedStateToLeast(RIGHT_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
			CSVStateCensus[] censusCsv = new Gson().fromJson(sortedStateCensusJson, CSVStateCensus[].class);
			Assert.assertEquals("Arunachal Pradesh", censusCsv[censusCsv.length - 1].stateName);
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenWrongIndiaCensusCsvWhenSortedOnStatePopulationDensityFileShouldThrowCensusAnalyserExceptionOfTypeCensusFileProblem() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getCensusDataFromMostDenslyPopulatedStateToLeast(WRONG_CENSUS_CSV,
					CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.CENSUS_FILE_PROBLEM, e.exceptionType);
		}
	}

	@Test
	public void givenWrongTypeIndiaCensusCsvFileWhenSortedOnStatePopulationDensityShouldThrowCensusAnalyserExceptionOfTypeIncorrectType() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getCensusDataFromMostDenslyPopulatedStateToLeast(WRONGTYPE_CENSUS_CSV,
					CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_TYPE, e.exceptionType);
		}
	}

	@Test
	public void givenIndiaCensusCsvFileWhenSortedOnStatePopulationDensityIncorrectDelimiterShouldThrowCensusAnalyserExceptionOfTypeIncorrectDelimiter() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getCensusDataFromMostDenslyPopulatedStateToLeast(WRONGDELIMITER_CENSUS_CSV,
					CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_DELIMITER, e.exceptionType);
		}
	}

	@Test
	public void givenIndiaCensusCsvFileWhenSortedOnStatePopulationDensityIncorrectHeaderShouldThrowCensusAnalyserExceptionOfTypeIncorrectHeader() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getCensusDataFromMostDenslyPopulatedStateToLeast(WRONGHEADER_CENSUS_CSV,
					CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_HEADER, e.exceptionType);
		}
	}

	@Test
	public void givenIndianCensusDataWhenSortedOnStateAreaShouldReturnSortedResult() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			String sortedStateCensusJson = stateCensusAnalyser
					.getCensusDataLargestStateToSmallestByArea(RIGHT_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
			CSVStateCensus[] censusCsv = new Gson().fromJson(sortedStateCensusJson, CSVStateCensus[].class);
			Assert.assertEquals("Rajasthan", censusCsv[0].stateName);
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenIndianCensusDataWhenSortedOnStateAreaShouldReturnSortedResultWithCorrectLeastDenslyPopulatedState() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			String sortedStateCensusJson = stateCensusAnalyser
					.getCensusDataLargestStateToSmallestByArea(RIGHT_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
			CSVStateCensus[] censusCsv = new Gson().fromJson(sortedStateCensusJson, CSVStateCensus[].class);
			Assert.assertEquals("Goa", censusCsv[censusCsv.length - 1].stateName);
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void givenWrongIndiaCensusCsvWhenSortedOnStateAreaFileShouldThrowCensusAnalyserExceptionOfTypeCensusFileProblem() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getCensusDataLargestStateToSmallestByArea(WRONG_CENSUS_CSV, CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.CENSUS_FILE_PROBLEM, e.exceptionType);
		}
	}

	@Test
	public void givenWrongTypeIndiaCensusCsvFileWhenSortedOnStateAreaShouldThrowCensusAnalyserExceptionOfTypeIncorrectType() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getCensusDataLargestStateToSmallestByArea(WRONGTYPE_CENSUS_CSV,
					CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_TYPE, e.exceptionType);
		}
	}

	@Test
	public void givenIndiaCensusCsvFileWhenSortedOnStateAreaIncorrectDelimiterShouldThrowCensusAnalyserExceptionOfTypeIncorrectDelimiter() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getCensusDataLargestStateToSmallestByArea(WRONGDELIMITER_CENSUS_CSV,
					CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_DELIMITER, e.exceptionType);
		}
	}

	@Test
	public void givenIndiaCensusCsvFileWhenSortedOnStateAreaIncorrectHeaderShouldThrowCensusAnalyserExceptionOfTypeIncorrectHeader() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CsvException.class);
			stateCensusAnalyser.getCensusDataLargestStateToSmallestByArea(WRONGHEADER_CENSUS_CSV,
					CsvBuilderType.OPEN_CSV);
		} catch (CsvException e) {
			Assert.assertEquals(CsvExceptionType.INCORRECT_HEADER, e.exceptionType);
		}
	}
}
