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
          name: 'ormorgid2',
          prop: 'ormorgid2',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgname2',
          prop: 'ormorgname2',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'jlcssj',
          prop: 'jlcssj',
          dataType: 'DATE',
        },
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
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimarchivesid',
          prop: 'pimarchivesid',
          dataType: 'PICKUP',
        },
        {
          name: 'ddjltype',
          prop: 'ddjltype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'pimarchiveschangename',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimarchiveschangeid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimarchiveschangeid',
          dataType: 'GUID',
        },
        {
          name: 'ormorgname',
          prop: 'ormorgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pimarchiveschange',
          prop: 'pimarchiveschangeid',
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