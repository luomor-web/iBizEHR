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
          name: 'pcmrcxlid2',
          prop: 'pcmrcxlid2',
          dataType: 'PICKUP',
        },
        {
          name: 'rcxllx',
          prop: 'rcxllx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'snumber',
          prop: 'snumber',
          dataType: 'INT',
        },
        {
          name: 'code',
          prop: 'code',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'rcxlmc',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmrcxlid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmrcxlid',
          dataType: 'GUID',
        },
        {
          name: 'rcxlmc',
          prop: 'rcxlmc',
          dataType: 'TEXT',
        },
        {
          name: 'pcmrcxlname2',
          prop: 'pcmrcxlname2',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'xldj',
          prop: 'xldj',
          dataType: 'TEXT',
        },
        {
          name: 'pcmrcxl',
          prop: 'pcmrcxlid',
        },
      {
        name: 'n_rcxllx_eq',
        prop: 'n_rcxllx_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pcmrcxlname_like',
        prop: 'n_pcmrcxlname_like',
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