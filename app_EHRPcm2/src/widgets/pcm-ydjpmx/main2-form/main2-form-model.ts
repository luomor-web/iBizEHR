/**
 * Main2 部件模型
 *
 * @export
 * @class Main2Model
 */
export default class Main2Model {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof Main2Model
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
        prop: 'pcmydjpmxid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmydjpmxname',
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
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'INHERIT',
      },
      {
        name: 'ygbh',
        prop: 'ygbh',
        dataType: 'INHERIT',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'INHERIT',
      },
      {
        name: 'zz',
        prop: 'zz',
        dataType: 'INHERIT',
      },
      {
        name: 'zzid',
        prop: 'zzid',
        dataType: 'INHERIT',
      },
      {
        name: 'bm',
        prop: 'bm',
        dataType: 'INHERIT',
      },
      {
        name: 'bmid',
        prop: 'bmid',
        dataType: 'INHERIT',
      },
      {
        name: 'yrank',
        prop: 'yrank',
        dataType: 'INHERIT',
      },
      {
        name: 'yzw',
        prop: 'yzw',
        dataType: 'INHERIT',
      },
      {
        name: 'ygw',
        prop: 'ygw',
        dataType: 'INHERIT',
      },
      {
        name: 'lxdh',
        prop: 'lxdh',
        dataType: 'INHERIT',
      },
      {
        name: 'sxrq',
        prop: 'sxrq',
        dataType: 'INHERIT',
      },
      {
        name: 'sfhmd',
        prop: 'sfhmd',
        dataType: 'INT',
      },
      {
        name: 'reason',
        prop: 'reason',
        dataType: 'SSCODELIST',
      },
      {
        name: 'jpfj',
        prop: 'jpfj',
        dataType: 'TEXT',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'remarks',
        prop: 'remarks',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'isfinished',
        prop: 'isfinished',
        dataType: 'SSCODELIST',
      },
      {
        name: 'sfzfbcj',
        prop: 'sfzfbcj',
        dataType: 'INT',
      },
      {
        name: 'bcjse',
        prop: 'bcjse',
        dataType: 'FLOAT',
      },
      {
        name: 'sfldzy',
        prop: 'sfldzy',
        dataType: 'INT',
      },
      {
        name: 'ldzytype',
        prop: 'ldzytype',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pcjse',
        prop: 'pcjse',
        dataType: 'FLOAT',
      },
      {
        name: 'pcmydjpmxid',
        prop: 'pcmydjpmxid',
        dataType: 'GUID',
      },
      {
        name: 'pcmydjpmx',
        prop: 'pcmydjpmxid',
        dataType: 'FONTKEY',
      },
    ]
  }

}