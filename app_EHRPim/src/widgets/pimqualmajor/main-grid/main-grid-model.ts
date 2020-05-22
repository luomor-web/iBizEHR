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
          name: 'zyzgzy',
          prop: 'zyzgzy',
          dataType: 'TEXT',
        },
        {
          name: 'pimqualtypeid',
          prop: 'pimqualtypeid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'quamajor',
          prop: 'quamajor',
          dataType: 'TEXT',
        },
        {
          name: 'qualevel',
          prop: 'qualevel',
          dataType: 'TEXT',
        },
        {
          name: 'pimqualmajorname',
          prop: 'pimqualmajorname',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'zyzgzy',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimqualmajorid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimqualmajorid',
          dataType: 'GUID',
        },
        {
          name: 'pimqualmajor',
          prop: 'pimqualmajorid',
        },
      {
        name: 'n_pimqualmajorname_like',
        prop: 'n_pimqualmajorname_like',
        dataType: 'TEXT',
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