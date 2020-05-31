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
          name: 'layerno',
          prop: 'layerno',
          dataType: 'SSCODELIST',
        },
        {
          name: 'bnumber',
          prop: 'bnumber',
          dataType: 'TEXT',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'archivescentername',
          prop: 'archivescentername',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'position',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'archivescenterid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'archivescenterid',
          dataType: 'GUID',
        },
        {
          name: 'cabinetno',
          prop: 'cabinetno',
          dataType: 'TEXT',
        },
        {
          name: 'serialno',
          prop: 'serialno',
          dataType: 'INT',
        },
        {
          name: 'pimarchivescenter',
          prop: 'archivescenterid',
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