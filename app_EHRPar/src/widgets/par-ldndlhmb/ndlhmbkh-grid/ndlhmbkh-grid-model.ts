/**
 * NDLHMBKH 部件模型
 *
 * @export
 * @class NDLHMBKHModel
 */
export default class NDLHMBKHModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof NDLHMBKHGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof NDLHMBKHGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'sstz',
          prop: 'sstz',
          dataType: 'TEXT',
        },
        {
          name: 'sszz',
          prop: 'sszz',
          dataType: 'TEXT',
        },
        {
          name: 'xh',
          prop: 'xh',
          dataType: 'INT',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'nd',
          prop: 'nd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ssbm',
          prop: 'ssbm',
          dataType: 'TEXT',
        },
        {
          name: 'jxjd',
          prop: 'jxjd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'parldndlhmbname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'parldndlhmbid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'parldndlhmbid',
          dataType: 'GUID',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'parldndlhmb',
          prop: 'parldndlhmbid',
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