/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'trmtrianpersonid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmtrianpersonname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ygbh',
        prop: 'ygbh',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'xb',
        prop: 'xb',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'nj',
        prop: 'nj',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'lxdh',
        prop: 'lxdh',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'zz',
        prop: 'zz',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'bm',
        prop: 'bm',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'zw',
        prop: 'zw',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'jsfs',
        prop: 'jsfs',
        dataType: 'TEXT',
      },
      {
        name: 'sfzs',
        prop: 'sfzs',
        dataType: 'YESNO',
      },
      {
        name: 'fjh',
        prop: 'fjh',
        dataType: 'TEXT',
      },
      {
        name: 'trmtrainplantermid',
        prop: 'trmtrainplantermid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmtrianpersonid',
        prop: 'trmtrianpersonid',
        dataType: 'GUID',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmtrainperson',
        prop: 'trmtrianpersonid',
        dataType: 'FONTKEY',
      },
    ]
  }

}