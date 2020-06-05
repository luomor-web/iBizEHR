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
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'bz',
          prop: 'bz',
          dataType: 'TEXT',
        },
        {
          name: 'sjqjks',
          prop: 'sjqjks',
          dataType: 'TEXT',
        },
        {
          name: 'state',
          prop: 'state',
          dataType: 'SSCODELIST',
        },
        {
          name: 'vacleavedetailid',
          prop: 'vacleavedetailid',
          dataType: 'GUID',
        },
        {
          name: 'srfmajortext',
          prop: 'vacleavedetailname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'vacleavedetailid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'vacleavedetailid',
          dataType: 'GUID',
        },
        {
          name: 'ormorgname',
          prop: 'ormorgname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ormorgsectorname',
          prop: 'ormorgsectorname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'jhqjks',
          prop: 'jhqjks',
          dataType: 'TEXT',
        },
        {
          name: 'sjts',
          prop: 'sjts',
          dataType: 'FLOAT',
        },
        {
          name: 'jhqjjs',
          prop: 'jhqjjs',
          dataType: 'TEXT',
        },
        {
          name: 'qjzl',
          prop: 'qjzl',
          dataType: 'SSCODELIST',
        },
        {
          name: 'sjqjjs',
          prop: 'sjqjjs',
          dataType: 'TEXT',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'jhts',
          prop: 'jhts',
          dataType: 'FLOAT',
        },
        {
          name: 'vacleavedetail',
          prop: 'vacleavedetailid',
        },
      {
        name: 'n_qjzl_eq',
        prop: 'n_qjzl_eq',
        dataType: 'SSCODELIST',
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