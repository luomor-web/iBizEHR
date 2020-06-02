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
          name: 'ffrs',
          prop: 'ffrs',
          dataType: 'INT',
        },
        {
          name: 'ffybz',
          prop: 'ffybz',
          dataType: 'TEXT',
        },
        {
          name: 'fylb',
          prop: 'fylb',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'ffsj',
          prop: 'ffsj',
          dataType: 'DATE',
        },
        {
          name: 'srfmajortext',
          prop: 'pimexpaccountname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimexpaccountid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimexpaccountid',
          dataType: 'GUID',
        },
        {
          name: 'fyje',
          prop: 'fyje',
          dataType: 'FLOAT',
        },
        {
          name: 'pimexpaccount',
          prop: 'pimexpaccountid',
        },
      {
        name: 'n_fylb_eq',
        prop: 'n_fylb_eq',
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