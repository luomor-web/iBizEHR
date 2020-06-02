/**
 * TXEditForm 部件模型
 *
 * @export
 * @class TXEditFormModel
 */
export default class TXEditFormModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof TXEditFormModel
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
        prop: 'pimpersonid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimpersonname',
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
        name: 'srfip_ygbh',
      },
      {
        name: 'srfip_pimpersonname',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'GUID',
      },
      {
        name: 'ygbh',
        prop: 'ygbh',
        dataType: 'TEXT',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'TEXT',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormorgsectorname',
        prop: 'ormorgsectorname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'rank',
        prop: 'rank',
        dataType: 'SSCODELIST',
      },
      {
        name: 'zw',
        prop: 'zw',
        dataType: 'SSCODELIST',
      },
      {
        name: 'gw',
        prop: 'gw',
        dataType: 'SSCODELIST',
      },
      {
        name: 'csrq',
        prop: 'csrq',
        dataType: 'DATE',
      },
      {
        name: 'lxdh',
        prop: 'lxdh',
        dataType: 'TEXT',
      },
      {
        name: 'sfznl',
        prop: 'sfznl',
        dataType: 'INT',
      },
      {
        name: 'postaladdress',
        prop: 'postaladdress',
        dataType: 'TEXT',
      },
      {
        name: 'sjtxrq',
        prop: 'sjtxrq',
        dataType: 'DATE',
      },
      {
        name: 'txnx',
        prop: 'txnx',
        dataType: 'TEXT',
      },
      {
        name: 'retiplace',
        prop: 'retiplace',
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
        name: 'pimperson',
        prop: 'pimpersonid',
        dataType: 'FONTKEY',
      },
    ]
  }

}