/**
 * HMDInfoGrid 部件模型
 *
 * @export
 * @class HMDInfoGridModel
 */
export default class HMDInfoGridModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof HMDInfoGridGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof HMDInfoGridGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'ygbh',
          prop: 'ygbh',
          dataType: 'TEXT',
        },
        {
          name: 'ormorgsectorid',
          prop: 'ormorgsectorid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimmajorsetypeid',
          prop: 'pimmajorsetypeid',
          dataType: 'PICKUP',
        },
        {
          name: 'pcmrcxlid',
          prop: 'pcmrcxlid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'pimpersonname',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'pimpersonid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimpersonid',
          dataType: 'GUID',
        },
        {
          name: 'pimcityid',
          prop: 'pimcityid',
          dataType: 'PICKUP',
        },
        {
          name: 'blacklistreasons',
          prop: 'blacklistreasons',
          dataType: 'TEXT',
        },
        {
          name: 'pcmjxsygzzjlmxid',
          prop: 'pcmjxsygzzjlmxid',
          dataType: 'PICKUP',
        },
        {
          name: 'zzdzs',
          prop: 'zzdzs',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ygzt',
          prop: 'ygzt',
          dataType: 'SSCODELIST',
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
          name: 'zjhm',
          prop: 'zjhm',
          dataType: 'TEXT',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'TEXT',
        },
        {
          name: 'hmd',
          prop: 'hmd',
          dataType: 'YESNO',
        },
        {
          name: 'pimperson',
          prop: 'pimpersonid',
        },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_ygbh_like',
        prop: 'n_ygbh_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_zjhm_like',
        prop: 'n_zjhm_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_ormorgname_like',
        prop: 'n_ormorgname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormorgsectorname_like',
        prop: 'n_ormorgsectorname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ygzt_eq',
        prop: 'n_ygzt_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_zgcode_eq',
        prop: 'n_zgcode_eq',
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