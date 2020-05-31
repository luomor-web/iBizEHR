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
          name: 'jyqssj',
          prop: 'jyqssj',
          dataType: 'DATE',
        },
        {
          name: 'spdate',
          prop: 'spdate',
          dataType: 'DATE',
        },
        {
          name: 'srfmajortext',
          prop: 'pimarchivesloanandreturnname',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'pimarchivesloanandreturnid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimarchivesloanandreturnid',
          dataType: 'GUID',
        },
        {
          name: 'ghrq',
          prop: 'ghrq',
          dataType: 'DATE',
        },
        {
          name: 'jyr',
          prop: 'jyr',
          dataType: 'TEXT',
        },
        {
          name: 'pimpersonid2',
          prop: 'pimpersonid2',
          dataType: 'PICKUP',
        },
        {
          name: 'pimpersonid3',
          prop: 'pimpersonid3',
          dataType: 'PICKUP',
        },
        {
          name: 'pimarchivesid',
          prop: 'pimarchivesid',
          dataType: 'PICKUP',
        },
        {
          name: 'zt',
          prop: 'zt',
          dataType: 'SSCODELIST',
        },
        {
          name: 'spperson',
          prop: 'spperson',
          dataType: 'TEXT',
        },
        {
          name: 'jyyy',
          prop: 'jyyy',
          dataType: 'TEXT',
        },
        {
          name: 'pimpersonname3',
          prop: 'pimpersonname3',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pimarchivesloanandreturn',
          prop: 'pimarchivesloanandreturnid',
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