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
          name: 'trooptype',
          prop: 'trooptype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'jlczz',
          prop: 'jlczz',
          dataType: 'TEXT',
        },
        {
          name: 'fj',
          prop: 'fj',
          dataType: 'LONGTEXT_1000',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'fssj',
          prop: 'fssj',
          dataType: 'DATE',
        },
        {
          name: 'leveltype_text',
          prop: 'leveltype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'trooptype_text',
          prop: 'trooptype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'pimarmycadresname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimarmycadresid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimarmycadresid',
          dataType: 'GUID',
        },
        {
          name: 'leveltype',
          prop: 'leveltype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimarmycadres',
          prop: 'pimarmycadresid',
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