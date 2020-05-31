/**
 * Main_Certificate 部件模型
 *
 * @export
 * @class Main_CertificateModel
 */
export default class Main_CertificateModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof Main_CertificateGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof Main_CertificateGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'zgsydw',
          prop: 'zgsydw',
          dataType: 'TEXT',
        },
        {
          name: 'ormorgsectorid',
          prop: 'ormorgsectorid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'zslx',
          prop: 'zslx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimvocationalcatalogid',
          prop: 'pimvocationalcatalogid',
          dataType: 'PICKUP',
        },
        {
          name: 'zghqrq',
          prop: 'zghqrq',
          dataType: 'DATE',
        },
        {
          name: 'zsmc',
          prop: 'zsmc',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'srfkey',
          prop: 'pimvocationalid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimvocationalid',
          dataType: 'GUID',
        },
        {
          name: 'jlspzt',
          prop: 'jlspzt',
          dataType: 'SSCODELIST',
        },
        {
          name: 'fzyxq',
          prop: 'fzyxq',
          dataType: 'TEXT',
        },
        {
          name: 'zgzsbh',
          prop: 'zgzsbh',
          dataType: 'TEXT',
        },
        {
          name: 'pimqualtypeid',
          prop: 'pimqualtypeid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimqualmajorid',
          prop: 'pimqualmajorid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormsignorgid',
          prop: 'ormsignorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimvocational',
          prop: 'pimvocationalid',
        },
      {
        name: 'n_ygbh_like',
        prop: 'n_ygbh_like',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ygzt_eq',
        prop: 'n_ygzt_eq',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_zslx_eq',
        prop: 'n_zslx_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_zsmc_like',
        prop: 'n_zsmc_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_zgzsbh_like',
        prop: 'n_zgzsbh_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_bcardnumber_like',
        prop: 'n_bcardnumber_like',
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