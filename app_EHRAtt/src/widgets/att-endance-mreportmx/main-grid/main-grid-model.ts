/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'day10',
          prop: 'day10',
          dataType: 'SSCODELIST',
        },
        {
          name: 'attendancemreportid2',
          prop: 'attendancemreportid2',
          dataType: 'PICKUP',
        },
        {
          name: 'ygbh',
          prop: 'ygbh',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'day31',
          prop: 'day31',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day13',
          prop: 'day13',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day14',
          prop: 'day14',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day11',
          prop: 'day11',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day30',
          prop: 'day30',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day12',
          prop: 'day12',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'attendancemreportname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'attendancemreportmxid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'attendancemreportmxid',
          dataType: 'GUID',
        },
        {
          name: 'kqhz',
          prop: 'kqhz',
          dataType: 'TEXT',
        },
        {
          name: 'bm',
          prop: 'bm',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'day29',
          prop: 'day29',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day28',
          prop: 'day28',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day27',
          prop: 'day27',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day26',
          prop: 'day26',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day22',
          prop: 'day22',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day23',
          prop: 'day23',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day24',
          prop: 'day24',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day25',
          prop: 'day25',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'gw',
          prop: 'gw',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'day20',
          prop: 'day20',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day21',
          prop: 'day21',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day3',
          prop: 'day3',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day2',
          prop: 'day2',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day1',
          prop: 'day1',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day19',
          prop: 'day19',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day9',
          prop: 'day9',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day8',
          prop: 'day8',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day7',
          prop: 'day7',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day16',
          prop: 'day16',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day6',
          prop: 'day6',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day15',
          prop: 'day15',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day5',
          prop: 'day5',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'day18',
          prop: 'day18',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day4',
          prop: 'day4',
          dataType: 'SSCODELIST',
        },
        {
          name: 'day17',
          prop: 'day17',
          dataType: 'SSCODELIST',
        },
        {
          name: 'attendancemreportmx',
          prop: 'attendancemreportmxid',
        },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
      },

        {
          name:'size',
          prop:'size'
        },
        {
          name:'query',
          prop:'query'
        },
        {
          name:'page',
          prop:'page'
        },
        {
          name:'sort',
          prop:'sort'
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata'
        },
        // 前端新增修改标识，新增为"0",修改为"1"或未设值
        {
          name: 'srffrontuf',
          prop: 'srffrontuf',
          dataType: 'TEXT',
        },
      ]
    }
  }

}